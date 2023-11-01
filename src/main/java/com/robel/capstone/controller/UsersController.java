package com.robel.capstone.controller;


import com.robel.capstone.model.UsersModel;
import com.robel.capstone.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String getSignInPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login";
    }


    @GetMapping("/register")
    public String getRegisterPage( Model model) {
        model.addAttribute("registerRequest", new UsersModel());

        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@ModelAttribute UsersModel  usersModel) {
        UsersModel registeredUser = usersService.registerUser(usersModel.getFirstName(), usersModel.getLastName(), usersModel.getEmail(), usersModel.getPassword());
       return registeredUser == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String postLoginPage(@ModelAttribute UsersModel  usersModel, Model model) {

        UsersModel authenticated = usersService.authenticateUser(usersModel.getEmail(), usersModel.getPassword());
       if(authenticated != null) {
           model.addAttribute("userLogin", authenticated.getEmail());
           return "home_page";
       }
       return "error_page";

    }

}
