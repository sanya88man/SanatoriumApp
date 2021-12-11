package by.martysiuk.sanatoriumApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthController {
    @GetMapping("/health/dentist")
    public String dentist() {
        return "health/dentist";
    }

    @GetMapping("/health/diagnostic")
    public String diagnostic() {
        return "health/diagnostic";
    }

    @GetMapping("/health/mineral")
    public String mineral() {
        return "health/mineral";
    }

    @GetMapping("/health/reflect")
    public String reflect() {
        return "health/reflect";
    }

    @GetMapping("/health/ozone")
    public String ozone() {
        return "health/ozone";
    }
}
