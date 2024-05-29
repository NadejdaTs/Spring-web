package softuni.bg.shopping.model.entity.binding;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.enums.CategoryName;
import softuni.bg.shopping.validation.annotation.DateTimeInFuture;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductBindingModel {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters!")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @DateTimeInFuture
    private String before;

    @Positive(message = "Price must be positive number!")
    @NotNull(message = "Price must be positive number!")
    private BigDecimal price;
    private CategoryName category;

}
