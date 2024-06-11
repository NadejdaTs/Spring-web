package softuni.repository;

import softuni.model.User;

import java.util.List;

public class InMemoryUserRepository implements UserRepository{
    @Override
    public List<User> findAll() {
        return List.of(
                new User("Ivan", "Ivanov", 20),
                new User("Georgi", "Georgiev", 30),
                new User("Petar", "Petrov", 40)
        );
    }
}
