package softuni.bg.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.shopping.model.entity.view.HomeViewModel;
import softuni.bg.shopping.service.LoggedUser;
import softuni.bg.shopping.service.ProductService;

@Controller
public class HomeController {
    private final ProductService productService;
    private final LoggedUser loggedUser;

    public HomeController(ProductService productService, LoggedUser loggedUser) {
        this.productService = productService;
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
        HomeViewModel homeViewModel = this.productService.getHomeViewData();
        return new ModelAndView("home", "products", homeViewModel);
    }
}
