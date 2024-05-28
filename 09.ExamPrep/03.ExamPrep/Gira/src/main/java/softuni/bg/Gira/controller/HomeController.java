package softuni.bg.Gira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.Gira.model.view.TaskHomeViewModel;
import softuni.bg.Gira.service.TaskService;
import softuni.bg.Gira.service.impl.LoggedUser;

@Controller
public class HomeController {
    private final TaskService taskService;
    private final LoggedUser loggedUser;

    public HomeController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
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

        TaskHomeViewModel viewModel = taskService.getHomeViewData(loggedUser.getEmail());
        return new ModelAndView("home", "tasks", viewModel);
    }
}
