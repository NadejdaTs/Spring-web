package softuni.bg.Gira.service;

import softuni.bg.Gira.model.binding.UserLoginBindingModel;
import softuni.bg.Gira.model.binding.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
