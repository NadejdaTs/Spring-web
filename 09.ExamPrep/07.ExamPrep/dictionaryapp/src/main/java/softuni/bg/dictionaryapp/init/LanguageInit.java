package softuni.bg.dictionaryapp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.dictionaryapp.model.entity.Language;
import softuni.bg.dictionaryapp.model.enums.LanguageEnum;
import softuni.bg.dictionaryapp.repo.LanguageRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LanguageInit implements CommandLineRunner {
    private final LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.languageRepository.count() == 0) {
            List<Language> languages = new ArrayList<>();

            Arrays.stream(LanguageEnum.values()).forEach(l -> {
                Language language = new Language();
                language.setName(l);
                language.setDescription(l);
                languages.add(language);
            });

            this.languageRepository.saveAll(languages);
        }
    }
}
