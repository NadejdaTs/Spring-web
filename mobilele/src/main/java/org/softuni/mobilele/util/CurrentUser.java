package org.softuni.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {
    private String firstName;
    private String lastName;
    private boolean isLogged;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        if(this.firstName != null){
            sb.append(this.firstName).append(" ");
        }
        if(this.lastName != null){
            sb.append(this.lastName);
        }
        return sb.toString().trim();
    }

    public void logout(){
        setLogged(false);
        setFirstName(null);
        setLastName(null);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }
}
