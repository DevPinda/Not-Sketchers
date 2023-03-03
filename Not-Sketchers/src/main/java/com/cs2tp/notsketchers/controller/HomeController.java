package com.cs2tp.notsketchers.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{
    @GetMapping("/")
    public String returnRoot(){
        return "home";
    }

    @GetMapping("/home")
    public String returnHome(){
        return "home";
    }
}