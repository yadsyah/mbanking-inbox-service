package id.co.diansetiyadi.inboxservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountInboxRequest extends BaseRequest {

    @NotBlank(message = "field cif must not be blank!")
    private String cif;
}
