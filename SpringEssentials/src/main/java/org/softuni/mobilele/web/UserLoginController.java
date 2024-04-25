package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private UserService userService;

//    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String  login(UserLoginDTO userLoginDTO){
        boolean isLoginSuccessfully = this.userService.loginUser(userLoginDTO);
        return isLoginSuccessfully ? "index" : "auth-login";
    }

    @GetMapping("users/logout")
    public String logout(){
        this.userService.logoutUser();
        return "index";
    }
}
