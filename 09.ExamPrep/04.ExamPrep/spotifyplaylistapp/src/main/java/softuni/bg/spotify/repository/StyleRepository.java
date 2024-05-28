package softuni.bg.spotify.repository;

import softuni.bg.spotify.model.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.spotify.model.entity.enums.StyleName;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Style, String> {
    Optional<Style> findByStyle(StyleName styleName);
}
