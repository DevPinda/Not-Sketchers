package com.cs2tp.notsketchers.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController{
    @GetMapping("/contact")
    public String returnContact(){
        return "contact";
    }
}
