package softuni.bg.dictionaryapp.service;

import softuni.bg.dictionaryapp.model.binding.UserLoginBindingModel;
import softuni.bg.dictionaryapp.model.binding.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
