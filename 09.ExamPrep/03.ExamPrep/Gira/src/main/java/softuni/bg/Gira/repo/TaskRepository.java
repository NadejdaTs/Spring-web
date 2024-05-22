package softuni.bg.Gira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Gira.model.entity.Task;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
