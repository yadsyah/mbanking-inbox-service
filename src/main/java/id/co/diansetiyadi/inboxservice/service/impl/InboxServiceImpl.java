package id.co.diansetiyadi.inboxservice.service.impl;

import id.co.diansetiyadi.inboxservice.dto.request.*;
import id.co.diansetiyadi.inboxservice.dto.response.*;
import id.co.diansetiyadi.inboxservice.entity.InboxEntity;
import id.co.diansetiyadi.inboxservice.handlings.InboxNotFoundException;
import id.co.diansetiyadi.inboxservice.repository.InboxRepository;
import id.co.diansetiyadi.inboxservice.service.InboxService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InboxServiceImpl implements InboxService {

    private final InboxRepository inboxRepository;

    @Autowired
    public InboxServiceImpl(InboxRepository inboxRepository) {
        this.inboxRepository = inboxRepository;
    }
    @Override
    public AddInboxResponse addInbox(AddInboxRequest addInboxRequest) {

        InboxEntity inboxEntity = new InboxEntity();
        inboxEntity.setCategory(addInboxRequest.getCategoryInboxEnum());
        inboxEntity.setCif(addInboxRequest.getCif());
        inboxEntity.setRead(false);
        inboxEntity.setMessageDetail(addInboxRequest.getMessageDetail());
        inboxEntity.setDeviceId(addInboxRequest.getDeviceId());
        inboxEntity.setAppVersion(addInboxRequest.getAppVersion());
        String idAddInbox = inboxRepository.save(inboxEntity).getId();

        return AddInboxResponse.builder().idInbox(idAddInbox).build();
    }

    @Override
    public DeleteInboxResponse deleteInbox(DeleteInboxRequest deleteInboxRequest) {

        InboxEntity checkExistInbox = inboxRepository.findById(deleteInboxRequest.getIdInbox()).orElseThrow(() -> new InboxNotFoundException("inbox not found!"));

        checkExistInbox.setDeleted(true);
        checkExistInbox.setActive(false);
        inboxRepository.save(checkExistInbox);
        return DeleteInboxResponse.builder().idInbox(checkExistInbox.getId()).build();
    }

    @Override
    public ReadFlagInboxResponse readByFlag(ReadFlagInboxRequest readFlagInboxRequest) {
        InboxEntity checkExistInbox = inboxRepository.findById(readFlagInboxRequest.getIdInbox()).orElseThrow(() -> new InboxNotFoundException("inbox not found!"));

        checkExistInbox.setRead(true);
        inboxRepository.save(checkExistInbox);
        return ReadFlagInboxResponse.builder().idInbox(checkExistInbox.getId()).build();
    }

    @SneakyThrows
    @Override
    public InquiryInboxResponse inquiryInbox(InquiryInboxRequest inquiryInboxRequest) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date startDateParse = sdf.parse(inquiryInboxRequest.getStartDate());
        Date endDateParse = sdf.parse(inquiryInboxRequest.getEndDate());

        List<InboxEntity> inboxEntityList = inboxRepository.findByCifAndDeletedIsFalseAndLastModifiedDateBetween(inquiryInboxRequest.getCif(), startDateParse, endDateParse);
        return InquiryInboxResponse.builder().listInbox(inboxEntityList).build();
    }

    @Override
    public CountInboxResponse countInbox(CountInboxRequest countInboxRequest) {
        Long totalCountInbox = inboxRepository.countByCif(countInboxRequest.getCif());
        return CountInboxResponse.builder().totalCount(totalCountInbox.toString()).build();
    }
}
