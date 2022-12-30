package id.co.diansetiyadi.inboxservice.dto.request;

import id.co.diansetiyadi.inboxservice.util.CategoryInboxEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddInboxRequest extends BaseRequest {

    private String messageDetail;
    private String cif;
    private CategoryInboxEnum categoryInboxEnum;
}
