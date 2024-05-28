package softuni.bg.shopping.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.shopping.model.entity.Category;
import softuni.bg.shopping.model.entity.enums.CategoryName;
import softuni.bg.shopping.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryInit implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() == 0){
            List<Category> categories = new ArrayList<>();
            Arrays.stream(CategoryName.values()).forEach(c -> {
                Category category = new Category();
                category.setName(c);
                category.setDescription(c.name().toLowerCase());

                categories.add(category);
            });

            this.categoryRepository.saveAll(categories);
        }
    }
}
