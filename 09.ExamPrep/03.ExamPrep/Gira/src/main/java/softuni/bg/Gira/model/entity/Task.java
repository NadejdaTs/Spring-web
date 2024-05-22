package softuni.bg.Gira.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import softuni.bg.Gira.model.enums.Progress;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Progress progress;

    private LocalDate dueDate;

    @ManyToOne
    private Classification classification;

    @ManyToOne
    private User user;
}
