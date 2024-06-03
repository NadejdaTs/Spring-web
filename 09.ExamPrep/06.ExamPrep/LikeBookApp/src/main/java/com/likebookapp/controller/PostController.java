package com.likebookapp.controller;

import com.likebookapp.model.LoggedUser;
import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.view.HomeViewModel;
import com.likebookapp.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    private final PostService postService;
    private final LoggedUser loggedUser;

    public PostController(PostService postService, LoggedUser loggedUser) {
        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/post/add")
    public ModelAndView addPost(@ModelAttribute("addPostBindingModel")
                                    AddPostBindingModel addPostBindingModel){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("/post-add");
    }

    @PostMapping("/post/add")
    public ModelAndView addPost(@ModelAttribute("addPostBindingModel")
                                    @Valid AddPostBindingModel addPostBindingModel,
                                    BindingResult bindingResult){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        if(bindingResult.hasErrors()){
            return new ModelAndView("/post-add");
        }

        this.postService.addPost(addPostBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/post/like/{id}")
    public ModelAndView likePost(@PathVariable("id") String id){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        this.postService.likePost(id);

        HomeViewModel homeViewModel = this.postService.getHomeViewData();
        return new ModelAndView("home", "posts", homeViewModel);
    }

    @PostMapping("/post/remove/{id}")
    public ModelAndView remove(@PathVariable("id") String id){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");
        }
        this.postService.remove(id);

        HomeViewModel homeViewModel = this.postService.getHomeViewData();
        return new ModelAndView("home", "posts", homeViewModel);
    }
}
