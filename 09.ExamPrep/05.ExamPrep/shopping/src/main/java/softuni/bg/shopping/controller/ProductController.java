package softuni.bg.shopping.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.shopping.model.entity.binding.AddProductBindingModel;
import softuni.bg.shopping.model.entity.view.HomeViewModel;
import softuni.bg.shopping.service.LoggedUser;
import softuni.bg.shopping.service.ProductService;

import java.math.BigDecimal;

@Controller
public class ProductController {
    private final ProductService productService;
    private final LoggedUser loggedUser;

    public ProductController(ProductService productService, LoggedUser loggedUser) {
        this.productService = productService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/product/add")
    public ModelAndView add(@ModelAttribute("addProductBindingModel") AddProductBindingModel addProductBindingModel){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        return new ModelAndView("/product-add");
    }

    @PostMapping("/product/add")
    public ModelAndView add(@ModelAttribute("addProductBindingModel")
                                @Valid AddProductBindingModel addProductBindingModel,
                                BindingResult bindingResult){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        if(bindingResult.hasErrors()){
            return new ModelAndView("/product-add");
        }

        this.productService.addProduct(addProductBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/product/buy/{id}")
    public ModelAndView buy(@PathVariable("id") String id){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        BigDecimal totalPrice = this.productService.buy(id);

        HomeViewModel homeViewModel = this.productService.getHomeViewData();
        homeViewModel.setTotalPrice(totalPrice);

        return new ModelAndView("home", "products", homeViewModel);
    }

    @PostMapping("/product/buyAll")
    public ModelAndView buyAll(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/users/login");
        }

        boolean hasBought = this.productService.buyAll();

        HomeViewModel homeViewModel = this.productService.getHomeViewData();

        return new ModelAndView("home", "products", homeViewModel);
    }
}
