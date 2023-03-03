package com.cs2tp.notsketchers.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController{
    @GetMapping("/about")
    public String returnAbout(){
        return "about";
    }
}
