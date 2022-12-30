package id.co.diansetiyadi.inboxservice.entity;

import id.co.diansetiyadi.inboxservice.util.CategoryInboxEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "inbox")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InboxEntity extends BaseEntity {

    @NotBlank(message = "field cif must not be blank!")
    private String cif;
    private String deviceId;
    private String messageDetail;
    private boolean isRead;
    @NotBlank(message = "field category enums most nut be blank!")
    @NotNull(message = "field category enums most nut be null!")
    private CategoryInboxEnum category;

}
