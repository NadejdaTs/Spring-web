package softuni.bg.dictionaryapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.dictionaryapp.model.enums.LanguageEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
public class Language extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private LanguageEnum name;

    @Column(nullable = false)
    private String description;

    @OneToMany
    private List<Word> words;

    public void setDescription(LanguageEnum language) {
        String desc = "";
        switch(language){
            case GERMAN -> desc = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
            case SPANISH -> desc = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
            case FRENCH -> desc = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
            case ITALIAN -> desc = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
        }
        this.description = desc;
    }

    public Language(){
        this.words = new ArrayList<>();
    }

}
