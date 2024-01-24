package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // RestController returns json data. Controller returns view resolver (returns file name).
public class HomeController {
    
    @GetMapping("home")
    public String home() {
        return "home";
    }

}
