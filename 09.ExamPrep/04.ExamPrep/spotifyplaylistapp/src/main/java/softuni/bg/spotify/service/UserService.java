package softuni.bg.spotify.service;

import softuni.bg.spotify.model.binding.UserLoginBindingModel;
import softuni.bg.spotify.model.binding.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
