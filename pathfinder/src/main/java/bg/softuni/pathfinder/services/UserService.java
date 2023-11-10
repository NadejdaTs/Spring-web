package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    boolean loginUser(String userName);
}
