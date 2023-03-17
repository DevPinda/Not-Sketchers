package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.CustomerEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NavBarController{
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/nav")
    public String returnNavBar(){
        return "nav";
    }

    @GetMapping("/checklogin")
    @ResponseBody
    public ResponseEntity<Void> checkLogin(HttpSession session) {
        CustomerEntity customer = (CustomerEntity) session.getAttribute("customer");
        if (customer != null) {
            return ResponseEntity.ok().build(); // user is logged in
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // user is not logged in
        }
    }

}