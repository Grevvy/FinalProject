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
        return "login";  // Serve the login.html page
    }

    // Handle login form submission
    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        // Hardcoded username and password for now
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home";  // Redirect to the home page on successful login
        } else {
            return "redirect:/?error";  // Redirect back to login with error
        }
    }

    // Show the homepage after successful login
    @GetMapping("/home")
    public String homepage() {
        return "home";  // Serve the home.html page after login
    }
}
