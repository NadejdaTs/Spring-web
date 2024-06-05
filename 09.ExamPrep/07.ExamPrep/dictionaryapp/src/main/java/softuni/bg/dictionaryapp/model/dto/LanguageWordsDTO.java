package softuni.bg.dictionaryapp.model.dto;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.dictionaryapp.model.entity.User;
import softuni.bg.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

@Getter
@Setter
public class LanguageWordsDTO {
    private String id;
    private String term;
    private String translation;
    private String example;
    private String inputDate;
    private String addedBy;

    public static LanguageWordsDTO createFromTask(Word word){
        LanguageWordsDTO myPostDTO = new LanguageWordsDTO();

        myPostDTO.setId(word.getId());
        myPostDTO.setTerm(word.getTerm());
        myPostDTO.setExample(word.getExample());
        myPostDTO.setAddedBy(word.getAddedBy().getUsername());
        myPostDTO.setTranslation(word.getTranslation());
        myPostDTO.setInputDate(word.getInputDate().toString());

        return myPostDTO;
    }
}
