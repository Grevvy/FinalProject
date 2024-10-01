package com.ServiceScout.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loginPage() {
        return "login.html";  // Serve login.html from static folder
    }

    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home";
        } else {
            return "redirect:/?error=true";
        }
    }

    @GetMapping("/home")
    public String homepage() {
        return "home.html";  // Serve home.html from static folder
    }
}
