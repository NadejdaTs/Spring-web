package softuni.bg.dictionaryapp.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.dictionaryapp.model.binding.AddWordBindingModel;
import softuni.bg.dictionaryapp.model.view.HomeViewModel;
import softuni.bg.dictionaryapp.service.LoggedUser;
import softuni.bg.dictionaryapp.service.WordService;

@Controller
public class WordController {
    private final WordService wordService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/word/add")
    public ModelAndView addPost(@ModelAttribute("addWordBindingModel")
                                AddWordBindingModel addPostBindingModel){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("/word-add");
    }

    @PostMapping("/word/add")
    public ModelAndView addPost(@ModelAttribute("addWordBindingModel")
                                @Valid AddWordBindingModel addPostBindingModel,
                                BindingResult bindingResult){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        if(bindingResult.hasErrors()){
            return new ModelAndView("/word-add");
        }

        this.wordService.addWord(addPostBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/word/remove/{id}")
    public ModelAndView remove(@PathVariable("id") String id){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        this.wordService.removeWord(id);

        HomeViewModel homeViewModel = this.wordService.getHomeViewData();
        return new ModelAndView("home", "words", homeViewModel);
    }

    @PostMapping("/word/removeAll")
    public ModelAndView removeAll(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        this.wordService.removeAll();

        HomeViewModel homeViewModel = this.wordService.getHomeViewData();
        return new ModelAndView("home", "words", homeViewModel);
    }
}
