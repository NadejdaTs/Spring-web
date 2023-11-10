package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return this.userService.getAll();
    }

   /* @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    /*@PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password){
        boolean isLoggedIn = this.userService.loginUser(userName);
//        if(isLoggedIn){
            return "redirect:/";
//        }
    }*/
}
