package softuni.bg.shopping.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.enums.CategoryName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime neededBefore;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryName category;
}
