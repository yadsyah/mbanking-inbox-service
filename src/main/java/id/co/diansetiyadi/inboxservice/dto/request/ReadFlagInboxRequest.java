package id.co.diansetiyadi.inboxservice.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReadFlagInboxRequest extends BaseRequest {

    private String idInbox;
}
