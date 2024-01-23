package com.synex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // RestController returns json data. Controller returns view resolver (returns file name).
public class TestController {
    
    @GetMapping(value = "test")
    public String test() {
        return "test";
    }
    
    @GetMapping(value = "welcome")
    public String welcome() {
        return "welcome";
    }
    
    @GetMapping(value = "restrict")
    public String restrict() {
        return "restrict";
    }
    
}
