package com.likebookapp.service;

import com.likebookapp.model.binding.UserLoginBindingModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
