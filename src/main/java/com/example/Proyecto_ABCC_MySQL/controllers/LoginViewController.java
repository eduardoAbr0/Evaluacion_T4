package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; 
    }

    @GetMapping("/")
    public String homePage() {
        return "list"; 
    }
}