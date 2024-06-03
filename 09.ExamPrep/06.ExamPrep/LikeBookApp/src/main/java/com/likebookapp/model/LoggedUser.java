package com.likebookapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class LoggedUser {
    private String username;
    private boolean isLogged;

    public void login(String username){
        this.username = username;
        this.isLogged = true;
    }

    public void logout(){
        this.username = null;
        this.isLogged = false;
    }
}
