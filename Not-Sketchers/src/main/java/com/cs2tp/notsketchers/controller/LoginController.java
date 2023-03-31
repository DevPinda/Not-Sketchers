package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.config.CustomerPasswordEncoder;
import com.cs2tp.notsketchers.entities.CustomerEntity;
import com.cs2tp.notsketchers.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController{
    @GetMapping("/login")
    public String returnLogin(){
        return "login";
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        CustomerEntity customerLogin = customerRepository.findByCustomerEmail(email);
        HttpSession session = request.getSession();
        CustomerPasswordEncoder passwordEncoder = new CustomerPasswordEncoder(12);

        if (customerLogin != null && passwordEncoder.matches(password, customerLogin.getCustomerPassword())) {
            session.setAttribute("customer", customerLogin);
            session.setAttribute("customerId", customerLogin.getCustomerId());
            if (customerLogin.isCustomerIsAdmin()) {
                System.out.println("Admin Login");
                return "redirect:/admin";
            } else if (customerLogin.isCustomerUser()) {
                System.out.println("User Login");
                return "redirect:/user";
            } else {
                return "redirect:/home";
            }
        } else {
            return "redirect:/login?error=invalid_login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}
