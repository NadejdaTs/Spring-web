package softuni.service;

import softuni.model.User;

import java.util.Optional;

public interface UserService{
    Optional<User> findYoungestUser();
}