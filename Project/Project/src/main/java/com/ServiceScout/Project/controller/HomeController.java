package com.ServiceScout.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        } else if ("contractor".equals(username) && "password".equals(password)) {
            return "redirect:/contractor_home";
        } else {
            return "redirect:/?error=true";
        }
    }

    @GetMapping("/home")
    public String homepage() {
        return "home.html";  // Serve home.html from static folder
    }

    @GetMapping("/create_contractor_account")
    public String createContractorAccountPage() {
        return "create_contractor_account.html";  // Serve contractor creation page
    }

    @PostMapping("/perform_contractor_creation")
    public String performContractorCreation(@RequestParam String name,
                                            @RequestParam String businessName,
                                            @RequestParam String phone,
                                            @RequestParam List<String> services, // Use List to capture multiple services
                                            @RequestParam String address) {
        // Here you would typically save the contractor details to your database
        // Example: Save name, businessName, phone, address, and services list to your database

        // Redirect to a success page or the homepage
        return "redirect:/home"; // Update as necessary
    }



}
