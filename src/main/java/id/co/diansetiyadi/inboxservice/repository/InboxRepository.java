package id.co.diansetiyadi.inboxservice.repository;

import id.co.diansetiyadi.inboxservice.entity.InboxEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InboxRepository extends MongoRepository<InboxEntity, String> {

    List<InboxEntity> findByCifAndDeletedIsFalse(String cif);
    List<InboxEntity> findByCifAndDeletedIsFalseAndLastModifiedDateBetween(String cif, Date startDate, Date endDate);

    @Query(value = "{'cif':?0 , 'deleted':false, 'isRead':false}", count = true)
    Long countByCif(String cif);

}
