package info.mastera.ondatotransponder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URI;
import java.util.Map;

@FeignClient(
        name = "ondato",
        url = "placeholder"
)
public interface OndatoHostClient {

    @PostMapping(path = "api/ondato/webhook/{identificationId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String transfer(URI baseUrl,
                    @PathVariable("identificationId") String identificationId,
                    @RequestHeader("x-api-key") String xApiKey,
                    @RequestBody Map<String, Object> identificationStatus);
}
