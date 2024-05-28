package softuni.bg.Gira.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.Gira.model.enums.ClassificationName;

@Entity
@Table(name = "classifications")
@Getter
@Setter
public class Classification extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ClassificationName name;

    @Column(nullable = false)
    private String description;


}
