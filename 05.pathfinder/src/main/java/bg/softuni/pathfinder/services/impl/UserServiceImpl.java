package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.services.UserService;
import bg.softuni.pathfinder.services.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser, UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
}
