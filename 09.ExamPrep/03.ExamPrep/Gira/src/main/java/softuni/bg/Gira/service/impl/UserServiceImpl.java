package softuni.bg.Gira.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.Gira.model.binding.UserLoginBindingModel;
import softuni.bg.Gira.model.binding.UserRegisterBindingModel;
import softuni.bg.Gira.model.entity.User;
import softuni.bg.Gira.repo.UserRepository;
import softuni.bg.Gira.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.mapper = mapper;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }
        String username = userRegisterBindingModel.getUsername();
        Optional<User> optUser = this.userRepository.findByUsernameOrEmail(username, userRegisterBindingModel.getEmail());

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
        String email = userLoginBindingModel.getEmail();
        User user = this.userRepository.findByEmail(email);

        if(user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())){
            this.loggedUser.login(email);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
