package id.co.diansetiyadi.inboxservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InquiryInboxRequest extends BaseRequest {

    private String cif;
    private String startDate;
    private String endDate;
}
