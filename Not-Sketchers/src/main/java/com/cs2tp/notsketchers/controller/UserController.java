package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.CustomerEntity;
import com.cs2tp.notsketchers.entities.OrdersEntity;
import com.cs2tp.notsketchers.repository.CustomerRepository;
import com.cs2tp.notsketchers.repository.OrdersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController{
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/user")
    public String returnUser(Model model) {
        if (this.isUser()) {
            CustomerEntity customer = this.getLoggedInUser();
            if (customer != null) {
                model.addAttribute("customer", customer);
                return "user";
            }
        }
        return "home";
    }

    @GetMapping("/userorder")
    public String returnUserOrder(Model model) {
        if (this.isUser()) {
            CustomerEntity customer = this.getLoggedInUser();
            if (customer != null) {
                model.addAttribute("customer", customer);
                int customerId = customer.getCustomerId();
                List<OrdersEntity> orders = ordersRepository.findByCustomerId(customerId);
                model.addAttribute("orders", orders);
                return "userorder";
            }
        }
        return "home";
    }

    private CustomerEntity getLoggedInUser() {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customer") != null) {
            CustomerEntity customer = (CustomerEntity) session.getAttribute("customer");
            String email = customer.getCustomerEmail();
            return customerRepository.findByCustomerEmail(email);
        }
        return null;
    }


    private boolean isUser() {
        CustomerEntity customer = this.getLoggedInUser();
        if (customer != null) {
            return customer.isCustomerUser();
        }
        return false;
    }
}
