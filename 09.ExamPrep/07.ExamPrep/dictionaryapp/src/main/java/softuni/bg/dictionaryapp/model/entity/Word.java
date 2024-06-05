package softuni.bg.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "words")
@Getter
@Setter
public class Word extends BaseEntity{
    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column
    private String example;

    @Column(nullable = false)
    private LocalDate inputDate;

    @ManyToOne
    @NotNull
    private Language language;

    @ManyToOne
    private User addedBy;
}
