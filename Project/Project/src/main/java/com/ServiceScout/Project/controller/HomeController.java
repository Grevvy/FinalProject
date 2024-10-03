package com.ServiceScout.Project.controller;


import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.*;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class HomeController {

    // Serve the login page
    @GetMapping("/")
    public String loginPage() {
        return "login.html";  // Serve login.html from static folder
    }

    // Serve the create user account page
    @GetMapping("/create_user_account")
    public String createUserAccountPage() {
        return "create_user_account.html";  // Serve user account creation page
    }

    // Handle user login
    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session) {

        if ("admin".equals(username) && "password".equals(password)) {
            session.setAttribute("userType", "admin");
            return "redirect:/admin";
        } else if ("contractor".equals(username) && "password".equals(password)) {
            session.setAttribute("userType", "contractor");
            return "redirect:/home";
        } else if ("user".equals(username) && "password".equals(password)) {
            session.setAttribute("userType", "user");
            return "redirect:/home";
        } else {
            return "redirect:/?error=true";
        }
    }

    // Serve the home page
    @GetMapping("/home")
    public String homepage() {
        return "home.html";  // Serve home.html from static folder
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin_dashboard.html";  // Make sure this corresponds to admin_dashboard.html
    }

    // Serve the create contractor account page
    @GetMapping("/create_contractor_account")
    public String createContractorAccountPage() {
        return "create_contractor_account.html";  // Serve contractor creation page
    }

    // Handle contractor account creation
    @PostMapping("/perform_contractor_creation")
    public String performContractorCreation(@RequestParam String name,
                                            @RequestParam String businessName,
                                            @RequestParam String phone,
                                            @RequestParam List<String> services,
                                            @RequestParam String address) {
        // Simulate saving contractor details
        System.out.println("Contractor created: " + name + ", Services: " + services);
        return "redirect:/home";
    }

    // Handle user account creation
    @PostMapping("/perform_user_creation")
    public String performUserCreation(@RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam String username,
                                      @RequestParam String password,
                                      @RequestParam String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            // Handle password mismatch
            return "redirect:/create_user_account?error=password_mismatch";
        }

        // Simulate saving user details
        System.out.println("User created: " + username + ", Email: " + email);
        return "redirect:/home";
    }

    // Serve the user profile page
    @GetMapping("/view_profile")
    public String viewProfile(HttpSession session) {
        if ("contractor".equals(session.getAttribute("userType"))) {
            return "contractor_profile.html";  // Redirect contractor to their profile view
        } else if ("user".equals(session.getAttribute("userType"))) {
            return "user_profile.html";  // Redirect user to their profile view
        } else {
            // Default case: maybe return to the login page or show an error
            return "redirect:/";
        }
    }


    // Serve the edit profile page.
    // goes to either a user edit profile or a contractor edit profile.
    @GetMapping("/edit_profile")
    public String editUserProfile(HttpSession session) {
        if ("user".equals(session.getAttribute("userType"))){
            return "edit_user_profile.html";
        } else if ("contractor".equals(session.getAttribute("userType"))){
            return "edit_contractor_profile.html";
        } else {
            // can change to error or something
            return "redirect:/";
        }

    }

    // Handle profile edit submission
    @PostMapping("/perform_edit_profile")
    public String performEditProfile(@RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String username) {
        // Log the updated profile details
        System.out.println("Profile updated: " + name + ", " + email + ", " + username);
        return "redirect:/view_profile";  // Redirect to the profile page after saving changes
    }

    // Handle logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";  // Redirect to login page
    }

    // Handle search functionality
    @GetMapping("/search_services")
    public String searchServices(@RequestParam String query) {
        // Simulate a search operation
        System.out.println("Search query: " + query);
        return "redirect:/home";  // Redirect back to home (update with results in the future)
    }

    @GetMapping("/edit_contractor_profile")
    public String editContractorProfilePage(HttpSession session) {
        // Add logic to check if the user is logged in and is a contractor
        return "redirect:/edit_contractor_profile.html";  // Serve the edit contractor profile page
    }

    @GetMapping("/view_requests")
    public String viewRequests(HttpSession session) {
        // Add logic to check if the user is logged in and is a contractor
        if (!"contractor".equals(session.getAttribute("userType"))) {
            return "redirect:/";  // Redirect to login if not a contractor
        }
        return "view_requests.html"; // Serve view_requests.html
    }

}

