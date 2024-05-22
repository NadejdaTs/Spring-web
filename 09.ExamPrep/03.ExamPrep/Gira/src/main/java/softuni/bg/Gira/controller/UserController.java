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

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     UserRegisterBindingModel userRegisterBindingModel){
        return new ModelAndView("/register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     @Valid UserRegisterBindingModel userRegisterBindingModel,
                                     BindingResult bindingResult){

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
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                                 @Valid UserLoginBindingModel userLoginBindingModel,
                                 BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        boolean isSuccessfulLogged = this.userService.login(userLoginBindingModel);
        if(!isSuccessfulLogged){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }
//        return new ModelAndView("redirect:/users/home");
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
