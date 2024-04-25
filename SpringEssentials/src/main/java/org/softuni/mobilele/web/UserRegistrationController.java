package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {
    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        //TODO: Registration email with activation link
        userService.registerUser(userRegistrationDTO); //N E V E R - antipattern (mainly with record)
        return "redirect:/";
    }

    /*register(@RequestParam("firstName") String firstName,
               @RequestParam("lastName") String lastName){}*/
}
