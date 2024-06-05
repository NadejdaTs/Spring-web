package softuni.bg.dictionaryapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.dictionaryapp.model.entity.Language;
import softuni.bg.dictionaryapp.model.enums.LanguageEnum;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {
    Language findByName(LanguageEnum german);
}
