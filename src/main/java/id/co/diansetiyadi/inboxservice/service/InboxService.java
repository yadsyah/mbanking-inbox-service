package id.co.diansetiyadi.inboxservice.service;

import id.co.diansetiyadi.inboxservice.dto.request.*;
import id.co.diansetiyadi.inboxservice.dto.response.*;

public interface InboxService {
    AddInboxResponse addInbox(AddInboxRequest addInboxRequest);
    DeleteInboxResponse deleteInbox(DeleteInboxRequest deleteInboxRequest);
    ReadFlagInboxResponse readByFlag(ReadFlagInboxRequest readFlagInboxRequest);
    InquiryInboxResponse inquiryInbox(InquiryInboxRequest inquiryInboxRequest);
    CountInboxResponse countInbox(CountInboxRequest countInboxRequest);
}
