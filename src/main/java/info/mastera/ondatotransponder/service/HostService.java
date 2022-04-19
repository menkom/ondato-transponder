package info.mastera.ondatotransponder.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Value("${hosts}")
    private List<String> hosts;

    public List<String> getAll() {
        return hosts;
    }

    public List<String> add(String newHost) {
        if (!hosts.contains(newHost)) {
            hosts.add(newHost);
        }
        return hosts;
    }

    public List<String> delete(String deleteHost) {
        hosts.remove(deleteHost);
        return hosts;
    }
}
