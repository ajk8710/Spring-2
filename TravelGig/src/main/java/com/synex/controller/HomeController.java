package com.synex.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // RestController returns json data. Controller returns view resolver (returns file name).
public class HomeController {
    
    @GetMapping("home")
    public String home(Principal principal, Model model) {
        String user = null;
        if (principal != null) {
            user = principal.getName();
        }
        model.addAttribute("user", user);  // get this by either request.getAttribute("user") or ${user} in home.jsp.
        
        return "home";
    }

}
