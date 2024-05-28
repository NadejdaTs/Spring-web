package softuni.bg.Gira.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.Gira.model.binding.UserLoginBindingModel;
import softuni.bg.Gira.model.binding.UserRegisterBindingModel;
import softuni.bg.Gira.service.UserService;
import softuni.bg.Gira.service.impl.LoggedUser;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     UserRegisterBindingModel userRegisterBindingModel){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("/register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     @Valid UserRegisterBindingModel userRegisterBindingModel,
                                     BindingResult bindingResult){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

        boolean isSuccessfulRegistered = this.userService.register(userRegisterBindingModel);
        if(!isSuccessfulRegistered){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError", true);
            return modelAndView;
        }
        return new ModelAndView("redirect:/users/login");
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                                  @Valid UserLoginBindingModel userLoginBindingModel){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                                 @Valid UserLoginBindingModel userLoginBindingModel,
                                 BindingResult bindingResult){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        if(bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        boolean isSuccessfulLogged = this.userService.login(userLoginBindingModel);
        if(!isSuccessfulLogged){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }

        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
