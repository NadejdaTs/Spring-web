package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public boolean loginUser(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.isPresent()){
            return true;
        }
        return false;
    }

}
