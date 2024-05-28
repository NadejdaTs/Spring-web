package softuni.bg.shopping.service;

import softuni.bg.shopping.model.entity.binding.UserLoginBindingModel;
import softuni.bg.shopping.model.entity.binding.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
