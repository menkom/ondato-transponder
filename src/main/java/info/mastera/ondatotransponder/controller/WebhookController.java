package info.mastera.ondatotransponder.controller;

import info.mastera.ondatotransponder.service.TransferService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/ondato")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebhookController {

    @Autowired
    TransferService transferService;

    @Async
    @PostMapping("webhook/{identificationId}")
    public void webhook(@PathVariable("identificationId") String identificationId,
                        @RequestHeader("x-api-key") String xApiKey,
                        @RequestBody Map<String, Object> identificationStatus) {
        log.info("Received id: {}, status: {}", identificationId, identificationStatus);

        transferService.transfer(identificationId, xApiKey, identificationStatus);
    }
}
