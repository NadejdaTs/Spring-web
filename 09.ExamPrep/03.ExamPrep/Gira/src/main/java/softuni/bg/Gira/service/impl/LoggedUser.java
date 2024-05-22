package softuni.bg.Gira.service.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class LoggedUser {
    private String email;
    private boolean isLogged;

    public void login(String email){
        this.email = email;
        this.isLogged = true;
    }

    public void logout(){
        this.email = null;
        this.isLogged = false;
    }
}
