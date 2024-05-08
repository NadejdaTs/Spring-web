package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.models.dto.UserRegisterBindingModel;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
