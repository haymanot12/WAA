package security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/shop")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/orders")
    public String user() {
        return ("<h1>Welcome From Sales Department</h1>");
    }

    @GetMapping("/payments")
    public String admin() {
        return ("<h1>Welcome From Finance Department</h1>");
    }
}
