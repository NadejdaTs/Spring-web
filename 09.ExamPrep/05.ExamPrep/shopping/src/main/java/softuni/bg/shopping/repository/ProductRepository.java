package softuni.bg.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.shopping.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
