package id.co.diansetiyadi.inboxservice.service.impl;

import id.co.diansetiyadi.inboxservice.dto.request.AddInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.DeleteInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.InquiryInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.ReadFlagInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.response.AddInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.DeleteInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.InquiryInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.ReadFlagInboxResponse;
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

        return DeleteInboxResponse.builder().idInbox(checkExistInbox.getId()).build();
    }

    @Override
    public ReadFlagInboxResponse readByFlag(ReadFlagInboxRequest readFlagInboxRequest) {
        InboxEntity checkExistInbox = inboxRepository.findById(readFlagInboxRequest.getIdInbox()).orElseThrow(() -> new InboxNotFoundException("inbox not found!"));

        checkExistInbox.setRead(true);
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
}
