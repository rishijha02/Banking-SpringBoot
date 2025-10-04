package com.rishi.bank.controller;

//import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class ErrorController {

    @GetMapping("/access-denied")
    public String accessDenied(Model model, Authentication authentication) {
        if (authentication != null) {
            String role = authentication.getAuthorities().toString();
            model.addAttribute("message", "Access denied! You are logged in as " + role + " but tried to access another role's area.");
        } else {
            model.addAttribute("message", "Access denied! You are not logged in.");
        }
        return "access-denied"; // access-denied.html
    }


}
