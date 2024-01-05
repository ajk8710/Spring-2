package com.synex.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    // RestController returns json data. Controller returns view resolver (returns file name).
    
    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }
}
