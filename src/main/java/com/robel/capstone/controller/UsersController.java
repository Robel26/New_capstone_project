package com.robel.capstone.controller;


import com.robel.capstone.dto.UserDTO;

import com.robel.capstone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/***
 *  this controller is for the register page the admin can register a new admin
 *  after registering the admin can login to the admin page
 */



@Controller
public class UsersController {

   private UserService userService;



    @Autowired
    public UsersController(UserService usersService) {
        this.userService = usersService;
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model) {
       model.addAttribute("user", new UserDTO());

        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@Valid @ModelAttribute("user") UserDTO userDTO,BindingResult bindingResult) {
     if (bindingResult.hasErrors()) {
            return "register";
        }
       userService.save(userDTO);
        return "redirect:/login?success";

    }





}
