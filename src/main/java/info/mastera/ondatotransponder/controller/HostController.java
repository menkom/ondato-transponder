package info.mastera.ondatotransponder.controller;

import info.mastera.ondatotransponder.service.HostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/ondato/host")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HostController {

    @Autowired
    HostService hostService;

    @GetMapping
    public List<String> getAll() {
        return hostService.getAll();
    }

    @PostMapping
    public List<String> add(@RequestBody String newHost) {
        return hostService.add(newHost);
    }

    @DeleteMapping
    public List<String> delete(@RequestBody String deleteHost) {
        return hostService.delete(deleteHost);
    }
}
