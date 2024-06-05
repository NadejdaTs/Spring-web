package softuni.bg.dictionaryapp.model.view;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.dictionaryapp.model.dto.LanguageWordsDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HomeViewModel {
    private List<LanguageWordsDTO> germanWords;
    private List<LanguageWordsDTO> spanishWords;
    private List<LanguageWordsDTO> frenchWords;
    private List<LanguageWordsDTO> italianWords;

    public HomeViewModel() {
        this.germanWords = new ArrayList<>();
        this.spanishWords = new ArrayList<>();
        this.frenchWords = new ArrayList<>();
        this.italianWords = new ArrayList<>();
    }


    public HomeViewModel(List<LanguageWordsDTO> germanWords, List<LanguageWordsDTO> spanishWords, List<LanguageWordsDTO> frenchWords, List<LanguageWordsDTO> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
    }
}
