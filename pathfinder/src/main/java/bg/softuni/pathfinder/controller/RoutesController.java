package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.dto.AddRouteBindingModel;
import bg.softuni.pathfinder.models.enums.CategoryName;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    private final RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView addRoute(){
        ModelAndView modelAndView = new ModelAndView("add-route");
        modelAndView.addObject("levels", Level.values());
        modelAndView.addObject("categories", CategoryName.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel){

        routeService.add(addRouteBindingModel);
        return new ModelAndView("redirect:/");
    }
}
