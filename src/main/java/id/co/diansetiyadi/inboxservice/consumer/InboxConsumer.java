package id.co.diansetiyadi.inboxservice.consumer;

import com.google.gson.Gson;
import id.co.diansetiyadi.inboxservice.dto.request.AddInboxRequest;
import id.co.diansetiyadi.inboxservice.service.InboxService;
import id.co.diansetiyadi.inboxservice.util.InboxConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InboxConsumer {

    private final InboxService inboxService;
    private final Gson gson;

    @Autowired
    public InboxConsumer(InboxService inboxService, Gson gson) {
        this.inboxService = inboxService;
        this.gson = gson;
    }

    @KafkaListener(topics = InboxConstant.TOPIC_NOTIFICATION_INBOX, groupId = "notification_inbox")
    public void consumeMessageInbox(String message) {
        log.info("Consume Kafka : {}", message);
        AddInboxRequest addInboxRequest = gson.fromJson(message, AddInboxRequest.class);
        inboxService.addInbox(addInboxRequest);
    }
}
