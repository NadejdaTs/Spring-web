package softuni.bg.Gira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Gira.model.binding.TasksAddBindingModel;
import softuni.bg.Gira.model.entity.Classification;
import softuni.bg.Gira.model.enums.ClassificationName;

import java.util.UUID;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
    Classification findByName(ClassificationName classificationName);
}
