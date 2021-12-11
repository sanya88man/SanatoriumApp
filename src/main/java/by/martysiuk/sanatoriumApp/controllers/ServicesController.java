package by.martysiuk.sanatoriumApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {
    @GetMapping("/services/spa")
    public String spa() {
        return "services/spa";
    }

    @GetMapping("/services/bar")
    public String bar() {
        return "services/bar";
    }

    @GetMapping("/services/swimmingPool")
    public String swim() {
        return "services/swimmingPool";
    }

    @GetMapping("/services/sauna")
    public String sauna() {
        return "services/sauna";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "services/contacts";
    }
}
