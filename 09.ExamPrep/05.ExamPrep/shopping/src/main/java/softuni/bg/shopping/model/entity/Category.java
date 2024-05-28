package softuni.bg.shopping.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.enums.CategoryName;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity{
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(nullable = false)
    private String description;
}
