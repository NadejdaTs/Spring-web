package softuni.bg.dictionaryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.dictionaryapp.model.view.HomeViewModel;
import softuni.bg.dictionaryapp.service.LoggedUser;
import softuni.bg.dictionaryapp.service.WordService;

@Controller
public class HomeController {
    private final WordService wordService;
    private final LoggedUser loggedUser;

    public HomeController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        HomeViewModel homeViewModel = this.wordService.getHomeViewData();
        return new ModelAndView("home", "words", homeViewModel);
    }
}
