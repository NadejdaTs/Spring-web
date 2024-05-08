package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.dto.AddRouteBindingModel;
import bg.softuni.pathfinder.models.enums.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    @GetMapping("/add")
    public ModelAndView addRoute(){
        ModelAndView modelAndView = new ModelAndView("add-route");
        modelAndView.addObject("levels", Level.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel){
        System.out.println();
        return new ModelAndView("add-route");
    }
}
