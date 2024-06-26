package softuni.bg.shopping.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import softuni.bg.shopping.model.entity.Product;
import softuni.bg.shopping.model.entity.User;
import softuni.bg.shopping.model.entity.binding.AddProductBindingModel;
import softuni.bg.shopping.model.entity.dto.ProductsDTO;
import softuni.bg.shopping.model.entity.enums.CategoryName;
import softuni.bg.shopping.model.entity.view.HomeViewModel;
import softuni.bg.shopping.repository.ProductRepository;
import softuni.bg.shopping.repository.UserRepository;
import softuni.bg.shopping.service.LoggedUser;
import softuni.bg.shopping.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, LoggedUser loggedUser, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public HomeViewModel getHomeViewData() {
        List<ProductsDTO> foods = this.productRepository.findByCategoryAndUserIsNull(CategoryName.FOOD)
                .stream()
                .map(ProductsDTO::createFromTask)
                .toList();
        List<ProductsDTO> drinks = this.productRepository.findByCategoryAndUserIsNull(CategoryName.DRINK)
                .stream()
                .map(ProductsDTO::createFromTask)
                .toList();
        List<ProductsDTO> households = this.productRepository.findByCategoryAndUserIsNull(CategoryName.HOUSEHOLD)
                .stream()
                .map(ProductsDTO::createFromTask)
                .toList();
        List<ProductsDTO> other = this.productRepository.findByCategoryAndUserIsNull(CategoryName.OTHER)
                .stream()
                .map(ProductsDTO::createFromTask)
                .toList();

        return new HomeViewModel(foods, drinks, households, other, BigDecimal.valueOf(0));
    }

    private BigDecimal getTotalPrice() {
        Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());
        if(optUser.isPresent()){
            BigDecimal totalPrice = BigDecimal.valueOf(0);

            List<ProductsDTO> allAssignedProducts = this.productRepository.findByUser(optUser.get())
                    .stream()
                    .map(ProductsDTO::createFromTask)
                    .toList();

            for (ProductsDTO allAssignedProduct : allAssignedProducts) {
                BigDecimal price = allAssignedProduct.getPrice();
                totalPrice = new BigDecimal(String.valueOf(totalPrice)).add(new BigDecimal(String.valueOf(price)));
            }

            return totalPrice;
        }
        return BigDecimal.valueOf(0);
    }

    @Override
    public boolean addProduct(AddProductBindingModel addProductBindingModel) {
        Optional<Product> optProduct = this.productRepository.findByName(addProductBindingModel.getName());

        if(!optProduct.isPresent() && addProductBindingModel.getCategory() != null){
            Product product = new Product();

            product.setName(addProductBindingModel.getName());
            product.setDescription(addProductBindingModel.getDescription());
            product.setCategory(addProductBindingModel.getCategory());
            product.setPrice(addProductBindingModel.getPrice());
            product.setNeededBefore(LocalDateTime.parse(addProductBindingModel.getBefore()));
            this.productRepository.save(product);

            return true;
        }
        return false;
    }

    @Override
    public BigDecimal buy(String id) {
        Optional<Product> optProduct = this.productRepository.findById(id);
        Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());

        Product product = optProduct.get();

        if(optProduct.isPresent()){
            product.setUser(optUser.get());
            this.productRepository.save(product);
            return getTotalPrice();
        }
        return BigDecimal.valueOf(0);
    }

    @Transactional
    @Override
    public boolean buyAll() {
        Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());
        Integer deleted = this.productRepository.deleteByUser(optUser.get());

        if(deleted > 0){
            return true;
        }

        return false;
    }
}
