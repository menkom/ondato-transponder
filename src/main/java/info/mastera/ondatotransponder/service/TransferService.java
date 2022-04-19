package info.mastera.ondatotransponder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class TransferService {

    @Autowired
    HostService hostService;
    @Autowired
    OndatoHostService ondatoHostService;

    public void transfer(String identificationId, String xApiKey, Map<String, Object> identificationStatus) {
        for (String host : hostService.getAll()) {
            ondatoHostService.transfer(host, identificationId, xApiKey, identificationStatus);
        }
    }
}
