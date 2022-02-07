package cors.corsissue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(value = "/testcors")
    public ResponseEntity<String> updateAccount() {
        return ResponseEntity.ok("Call success");
    }
}
