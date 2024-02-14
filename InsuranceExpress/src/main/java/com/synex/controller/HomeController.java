package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // RestController returns json data. Controller returns view resolver (returns file name).
public class HomeController {
    
    @GetMapping("index")
    public String index() {
        return "index";
    }
    
    @GetMapping("blog")
    public String blog() {
        return "blog";
    }
    
    @GetMapping("blog-details")
    public String blogDetails() {
        return "blog-details";
    }
    
    @GetMapping("contact-us")
    public String contactUs() {
        return "contact-us";
    }
    
    @GetMapping("select-plan")
    public String selectPlan() {
        return "select-plan";
    }
    
}
