package com.ServiceScout.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Show login page as the first page
    @GetMapping("/")
    public String loginPage() {
        return "login.html";  // Explicitly serve login.html from the static folder
    }

    // Handle login form submission
    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        // Hardcoded username and password for now
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home";  // Redirect to the home page on successful login
        } else {
            return "redirect:/?error=true";  // Redirect back to login with error
        }
    }

    // Show the homepage after successful login
    @GetMapping("/home")
    public String homepage() {
        return "home.html";  // Explicitly serve home.html from the static folder
    }
}
