package id.co.diansetiyadi.inboxservice.entity;

import id.co.diansetiyadi.inboxservice.util.CategoryInboxEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "inbox")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InboxEntity extends BaseEntity {

    private String cif;
    private String deviceId;
    private String messageDetail;
    private boolean isRead;
    private CategoryInboxEnum category;

}
