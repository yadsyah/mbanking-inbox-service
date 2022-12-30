package id.co.diansetiyadi.inboxservice.service;

import id.co.diansetiyadi.inboxservice.dto.request.AddInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.DeleteInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.InquiryInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.ReadFlagInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.response.AddInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.DeleteInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.InquiryInboxResponse;
import id.co.diansetiyadi.inboxservice.dto.response.ReadFlagInboxResponse;

public interface InboxService {
    AddInboxResponse addInbox(AddInboxRequest addInboxRequest);
    DeleteInboxResponse deleteInbox(DeleteInboxRequest deleteInboxRequest);
    ReadFlagInboxResponse readByFlag(ReadFlagInboxRequest readFlagInboxRequest);
    InquiryInboxResponse inquiryInbox(InquiryInboxRequest inquiryInboxRequest);
}
