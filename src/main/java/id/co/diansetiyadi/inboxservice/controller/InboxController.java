package id.co.diansetiyadi.inboxservice.controller;

import id.co.diansetiyadi.inboxservice.dto.response.BaseResponse;
import id.co.diansetiyadi.inboxservice.service.InboxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@Slf4j
public class InboxController {

    private final InboxService inboxService;

    @Autowired
    public InboxController(InboxService inboxService) {
        this.inboxService = inboxService;
    }

    @PostMapping("/add")
    public Mono<BaseResponse> addInbox() {
        return Mono.just(BaseResponse.builder().responseCode("00").message("Success").traceId(UUID.randomUUID().toString()).data(inboxService.addInbox()).build());
    }
}
