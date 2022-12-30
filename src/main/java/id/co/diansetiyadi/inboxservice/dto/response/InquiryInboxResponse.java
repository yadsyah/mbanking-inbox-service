package id.co.diansetiyadi.inboxservice.dto.response;

import id.co.diansetiyadi.inboxservice.entity.InboxEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class InquiryInboxResponse {

    List<InboxEntity> listInbox;
}
