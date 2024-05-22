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

    @Enumerated(EnumType.STRING)
    private ClassificationName name;

    private String description;
}
