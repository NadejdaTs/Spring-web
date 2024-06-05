package softuni.bg.dictionaryapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.dictionaryapp.model.entity.Language;
import softuni.bg.dictionaryapp.model.entity.Word;
import softuni.bg.dictionaryapp.model.enums.LanguageEnum;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    List<Word> findByLanguage(Language language);

    Optional<Word> findByTerm(String term);
}
