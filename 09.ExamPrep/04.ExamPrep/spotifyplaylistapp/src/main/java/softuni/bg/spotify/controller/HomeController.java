package softuni.bg.spotify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.spotify.service.LoggedUser;
import softuni.bg.spotify.service.SongService;

@Controller
public class HomeController {
    private final SongService songService;
    private final LoggedUser loggedUser;

    public HomeController(SongService songService, LoggedUser loggedUser) {
        this.songService = songService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(Model model){
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("songs", this.songService.getSongs());
//        modelAndView.addObject("playList", this.songService.getPlaylist(loggedUser.getUsername()));

        return modelAndView;
    }
}
