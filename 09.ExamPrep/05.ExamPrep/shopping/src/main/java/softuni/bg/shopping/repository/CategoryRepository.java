package softuni.bg.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.shopping.model.entity.Category;
import softuni.bg.shopping.model.entity.enums.CategoryName;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(CategoryName food);

}
