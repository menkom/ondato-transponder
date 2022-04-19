package info.mastera.ondatotransponder.service;

import info.mastera.ondatotransponder.client.OndatoHostClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Slf4j
@Service
public class OndatoHostService {

    @Autowired
    OndatoHostClient ondatoHostClient;

    public void transfer(String host, String identificationId, String xApiKey, Map<String, Object> identificationStatus) {
        try {
            log.info("Transferring data to {}", host);
            ondatoHostClient.transfer(URI.create(host), identificationId, xApiKey, identificationStatus);
        } catch (FeignException ex) {
            log.error("Error on transferring webhook to {}.", host, ex);
        }
    }
}
