package com.likebookapp.service.impl;

import com.likebookapp.model.LoggedUser;
import com.likebookapp.model.binding.UserLoginBindingModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        String password = userRegisterBindingModel.getPassword();
        if(!password.equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }

        String username = userRegisterBindingModel.getUsername();
        Optional<User> optUser = this.userRepository.findByUsernameOrEmail(username, userRegisterBindingModel.getEmail());
        if(optUser.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(this.passwordEncoder.encode(password));
        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        Optional<User> optUser = this.userRepository.findByUsername(username);
        if(optUser.isPresent() && this.passwordEncoder.matches(userLoginBindingModel.getPassword(), optUser.get().getPassword())){
            this.loggedUser.login(username);
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
