package softuni.bg.Gira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Gira.model.entity.Classification;

import java.util.UUID;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
}
