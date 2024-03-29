package com.synex.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.synex.domain.User;
import com.synex.repository.UserRepository;
import com.synex.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {
    
    @Autowired UserService userService;
    
    @GetMapping("login")
    public String login(@RequestParam(required = false) String logout, @RequestParam(required = false) String error,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        String message = "";  // message after login logout
        if (error != null) {
            message = "Invalid Credentials";
        }
        if (logout != null) {  // logout is empty string, not null, if parameter has passed (login?logout)
            // Following lines can also done by SecurityConfig .logout() - invalidate session & clear auth
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
            }
            message = "Logout";
        }
        model.addAttribute("Message", message);
        
        // return login.jsp if login failed. If success, go to home using SecurityConfig: .defaultSuccessUrl("/home", true)
        return "login";
    }
    
    @GetMapping("accessDeniedPage")
    public String accessDenied(Principal principal, Model model) {
        String message = principal.getName() + ", Unauthorised access";
        model.addAttribute("Message", message);
        return "accessDenied";

    }
    
    @GetMapping("signup")
    public String signup(@RequestParam String userEmail, @RequestParam String userName, @RequestParam String password) {
        return "login";
    }
    
    @GetMapping("/user/{username}")
    @ResponseBody
    public String getUserByUsername(@PathVariable String username) {
        return userService.findByUserName(username).getEmail();
    }
    
//  @Bean
//  public BCryptPasswordEncoder bCryptpeasswordEncoder() {
//      return new BCryptPasswordEncoder();
//  }

}
