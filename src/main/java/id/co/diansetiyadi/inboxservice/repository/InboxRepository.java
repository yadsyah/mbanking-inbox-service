package id.co.diansetiyadi.inboxservice.repository;

import id.co.diansetiyadi.inboxservice.entity.InboxEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InboxRepository extends MongoRepository<InboxEntity, String> {

    List<InboxEntity> findByCifAndDeletedIsFalse(String cif);

    List<InboxEntity> findByCifAndDeletedIsFalseAndLastModifiedDateBetween(String cif, Date startDate, Date endDate);

}
