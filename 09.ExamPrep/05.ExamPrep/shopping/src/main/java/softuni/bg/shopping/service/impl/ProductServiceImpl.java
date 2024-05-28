package softuni.bg.shopping.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.shopping.model.entity.User;
import softuni.bg.shopping.model.entity.view.HomeViewModel;
import softuni.bg.shopping.repository.ProductRepository;
import softuni.bg.shopping.repository.UserRepository;
import softuni.bg.shopping.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public HomeViewModel getHomeViewData(String username) {
//        Optional<User> optUser = this.userRepository.findByUsername(username);
//        optUser.get().get
//        this.productRepository.findBy
        return null;
    }
}
