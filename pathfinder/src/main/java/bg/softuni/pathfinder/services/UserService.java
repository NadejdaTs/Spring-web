package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getLoggedUser();
}
