package id.co.diansetiyadi.inboxservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CountInboxResponse {

    private String totalCount;
}
