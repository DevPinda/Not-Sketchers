package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.CustomerEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController{
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/admin")
    public String returnAdmin() {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customer") != null) {
            CustomerEntity customer = (CustomerEntity) session.getAttribute("customer");
            if (customer.isCustomerIsAdmin()) {
                System.out.println("Admin");
                return "admin";
            }
        }
        return "home";
    }
}