package by.martysiuk.sanatoriumApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/dentist")
    public String dentist() {
        return "health/dentist";
    }

    @GetMapping("/diagnostic")
    public String diagnostic() {
        return "health/diagnostic";
    }

    @GetMapping("/mineral")
    public String mineral() {
        return "health/mineral";
    }

    @GetMapping("/reflect")
    public String reflect() {
        return "health/reflect";
    }

    @GetMapping("/ozone")
    public String ozone() {
        return "health/ozone";
    }
}
