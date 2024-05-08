package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.models.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBindingModel userLoginBindingModel){
        boolean isLogged = this.userService.login(userLoginBindingModel);

        if(isLogged){
            return new ModelAndView(("redirect:/"));
        }
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel){
        this.userService.register(userRegisterBindingModel);
        return new ModelAndView("redirect:login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
