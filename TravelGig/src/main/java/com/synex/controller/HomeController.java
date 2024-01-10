package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // RestController returns json data. Controller returns view resolver (returns file name).
    
    @GetMapping("home")
    public String home() {
        return "home";
    }
}
