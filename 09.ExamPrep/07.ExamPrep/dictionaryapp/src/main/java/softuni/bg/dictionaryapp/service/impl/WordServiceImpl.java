package softuni.bg.dictionaryapp.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import softuni.bg.dictionaryapp.model.binding.AddWordBindingModel;
import softuni.bg.dictionaryapp.model.dto.LanguageWordsDTO;
import softuni.bg.dictionaryapp.model.entity.Language;
import softuni.bg.dictionaryapp.model.entity.User;
import softuni.bg.dictionaryapp.model.entity.Word;
import softuni.bg.dictionaryapp.model.enums.LanguageEnum;
import softuni.bg.dictionaryapp.model.view.HomeViewModel;
import softuni.bg.dictionaryapp.repo.LanguageRepository;
import softuni.bg.dictionaryapp.repo.UserRepository;
import softuni.bg.dictionaryapp.repo.WordRepository;
import softuni.bg.dictionaryapp.service.LoggedUser;
import softuni.bg.dictionaryapp.service.WordService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository, LanguageRepository languageRepository, LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        this.loggedUser = loggedUser;;
    }

    @Override
    public HomeViewModel getHomeViewData() {
        Language german = this.languageRepository.findByName(LanguageEnum.GERMAN);
        List<LanguageWordsDTO> germanWords = this.wordRepository.findByLanguage(german).stream()
                .map(LanguageWordsDTO::createFromTask)
                .toList();

        Language spanish = this.languageRepository.findByName(LanguageEnum.SPANISH);
        List<LanguageWordsDTO> spanishWords = this.wordRepository.findByLanguage(spanish).stream()
                .map(LanguageWordsDTO::createFromTask)
                .toList();

        Language french = this.languageRepository.findByName(LanguageEnum.FRENCH);
        List<LanguageWordsDTO> frenchWords = this.wordRepository.findByLanguage(french).stream()
                .map(LanguageWordsDTO::createFromTask)
                .toList();

        Language italian = this.languageRepository.findByName(LanguageEnum.ITALIAN);
        List<LanguageWordsDTO> italianWords = this.wordRepository.findByLanguage(italian).stream()
                .map(LanguageWordsDTO::createFromTask)
                .toList();
        long totalWords = this.wordRepository.count();

        return new HomeViewModel(germanWords, spanishWords, frenchWords, italianWords, totalWords);
    }

    @Override
    public void addWord(AddWordBindingModel addWordBindingModel) {
        Optional<Word> optTerm = this.wordRepository.findByTerm(addWordBindingModel.getTerm());
        if(!optTerm.isPresent()){
            LanguageEnum languageEnum = LanguageEnum.valueOf(addWordBindingModel.getLanguage());
            Language language = this.languageRepository.findByName(languageEnum);
            Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());

            Word word = new Word();

            word.setTerm(addWordBindingModel.getTerm());
            word.setExample(addWordBindingModel.getExample());
            word.setTranslation(addWordBindingModel.getTranslation());
            word.setLanguage(language);
            word.setAddedBy(optUser.get());
            word.setInputDate(LocalDate.parse(addWordBindingModel.getInputDate()));

            this.wordRepository.save(word);
        }
    }

    @Transactional
    @Override
    public void removeWord(String id) {
        Optional<Word> optWord = this.wordRepository.findById(id);

        if(optWord.isPresent()){
            this.wordRepository.delete(optWord.get());
        }
    }

    @Override
    public void removeAll() {
        this.wordRepository.deleteAll();
    }
}
