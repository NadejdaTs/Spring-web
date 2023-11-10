package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(UserRegisterBindingModel userRegisterBindingModel){
        return "register";
    }

    @PostMapping("/login")
    public String login(String username, String password){
        boolean isLoggedIn = this.userService.loginUser(username);
        /*if(isLoggedIn){
            return "redirect:/";
        }*/
        return "register";
    }
}
