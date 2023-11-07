package softuni.repository;

import softuni.model.User;

import java.util.List;

public interface UserRepository{
    List<User> findAll();
}