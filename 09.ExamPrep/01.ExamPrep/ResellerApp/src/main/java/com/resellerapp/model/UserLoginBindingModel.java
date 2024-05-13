package com.resellerapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserLoginBindingModel {
    @Length(min = 3, max = 20)
    private String username;

    @Length(min = 3, max = 20)
    private String password;
}
