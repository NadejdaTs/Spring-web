package softuni.bg.shopping.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.shopping.model.entity.User;
import softuni.bg.shopping.model.entity.binding.UserLoginBindingModel;
import softuni.bg.shopping.model.entity.binding.UserRegisterBindingModel;
import softuni.bg.shopping.repository.UserRepository;
import softuni.bg.shopping.service.LoggedUser;
import softuni.bg.shopping.service.UserService;

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
        String password = userRegisterBindingModel.getConfirmPassword();
        if(!password.equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }

        Optional<User> optUser = this.userRepository.findByUsername(userRegisterBindingModel.getUsername());
        if(optUser.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
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
