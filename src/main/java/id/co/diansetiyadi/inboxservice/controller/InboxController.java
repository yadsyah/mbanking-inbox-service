package id.co.diansetiyadi.inboxservice.controller;

import id.co.diansetiyadi.inboxservice.dto.request.AddInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.DeleteInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.InquiryInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.request.ReadFlagInboxRequest;
import id.co.diansetiyadi.inboxservice.dto.response.BaseResponse;
import id.co.diansetiyadi.inboxservice.service.InboxService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
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
    @ResponseBody
    public Mono<BaseResponse> addInbox(@RequestBody @Valid AddInboxRequest addInboxRequest) {
        return Mono.just(BaseResponse.builder()
                .responseCode("00")
                .message("Success")
                .traceId(UUID.randomUUID().toString())
                .data(inboxService.addInbox(addInboxRequest))
                .build());
    }

    @PostMapping("/inquiry")
    @ResponseBody
    public Flux<BaseResponse> inquiryInbox(@RequestBody @Valid InquiryInboxRequest inquiryInboxRequest) {
        return Flux.just(BaseResponse.builder()
                .responseCode("00")
                .message("Success")
                .traceId(UUID.randomUUID().toString())
                .data(inboxService.inquiryInbox(inquiryInboxRequest))
                .build());
    }

    @PostMapping("/read-flag")
    @ResponseBody
    public Mono<BaseResponse> readFlagInbox(@RequestBody @Valid ReadFlagInboxRequest readFlagInboxRequest) {
        return Mono.just(BaseResponse.builder()
                .responseCode("00")
                .message("Success")
                .traceId(UUID.randomUUID().toString())
                .data(inboxService.readByFlag(readFlagInboxRequest))
                .build());
    }

    @PostMapping("/delete")
    @ResponseBody
    public Mono<BaseResponse> deleteInbox(@RequestBody @Valid DeleteInboxRequest deleteInboxRequest) {
        return Mono.just(BaseResponse.builder()
                .responseCode("00")
                .message("Success")
                .traceId(UUID.randomUUID().toString())
                .data(inboxService.deleteInbox(deleteInboxRequest))
                .build());
    }
}
