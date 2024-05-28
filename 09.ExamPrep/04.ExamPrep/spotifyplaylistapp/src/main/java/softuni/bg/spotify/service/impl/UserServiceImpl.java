package softuni.bg.spotify.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.spotify.model.binding.UserLoginBindingModel;
import softuni.bg.spotify.model.binding.UserRegisterBindingModel;
import softuni.bg.spotify.model.entity.User;
import softuni.bg.spotify.repository.UserRepository;
import softuni.bg.spotify.service.LoggedUser;
import softuni.bg.spotify.service.UserService;

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
        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }
        Optional<User> optUser = this.userRepository.findByUsernameOrEmail(userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());

        if(optUser.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        Optional<User> optUser = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if(optUser != null && this.passwordEncoder.matches(userLoginBindingModel.getPassword(), optUser.get().getPassword())){
            this.loggedUser.login(userLoginBindingModel.getUsername());
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
