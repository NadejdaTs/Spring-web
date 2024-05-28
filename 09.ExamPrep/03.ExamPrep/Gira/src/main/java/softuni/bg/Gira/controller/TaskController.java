package softuni.bg.Gira.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.Gira.model.binding.TasksAddBindingModel;
import softuni.bg.Gira.service.TaskService;
import softuni.bg.Gira.service.impl.LoggedUser;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final LoggedUser loggedUser;

    public TaskController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public ModelAndView add(@ModelAttribute("tasksAddBindingModel") TasksAddBindingModel tasksAddBindingModel){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        return new ModelAndView("/add-task");
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("tasksAddBindingModel") @Valid TasksAddBindingModel tasksAddBindingModel,
                            BindingResult bindingResult){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        if(bindingResult.hasErrors()){
            return new ModelAndView("add-task");
        }

        this.taskService.add(tasksAddBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/progress/{id}")
    public ModelAndView progress(@PathVariable("id") String id){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        this.taskService.progress(id, loggedUser.getEmail());

        return new ModelAndView("redirect:/home");
    }
}
