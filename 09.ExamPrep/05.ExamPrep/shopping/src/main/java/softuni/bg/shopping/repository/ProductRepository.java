package softuni.bg.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.shopping.model.entity.Product;
import softuni.bg.shopping.model.entity.User;
import softuni.bg.shopping.model.entity.enums.CategoryName;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByName(String name);

    List<Product> findByCategoryAndUserIsNull(CategoryName drink);

    List<Product> findByUser(User user);

    boolean deleteAllByUser(User user);
}
