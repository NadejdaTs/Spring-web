package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.exception.UserNotFoundException;
import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.services.UserService;
import bg.softuni.pathfinder.services.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(LoggedUser loggedUser, UserRepository userRepository, ModelMapper mapper) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<User> getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        String username = loggedUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with name: " + username + " was not found!"));
        return mapper.map(user, UserProfileViewModel.class);
    }
}
