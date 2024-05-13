package com.resellerapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRegisterBindingModel {
    @Length(min = 3, max = 20)
    private String username;

    @Length(min = 3, max = 20)
    private String password;

    private String confirmPassword;

//    @NotBlank
    @Email
    private String email;

}
