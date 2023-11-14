package com.robel.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
This section is for the login controller. as the admin you can login to the admin page

*/
@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }
    @RequestMapping("/account")
    public String loginProcess() {
        return "redirect:/admin";
    }
}
