package security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/shop")
    public String home() {
        return ("<h1>Shop</h1>");
    }

    @GetMapping("/orders")
    public String user() {
        return ("<h1>Orders</h1>");
    }

    @GetMapping("/payment")
    public String admin() {
        return ("<h1>Payments</h1>");
    }
}
