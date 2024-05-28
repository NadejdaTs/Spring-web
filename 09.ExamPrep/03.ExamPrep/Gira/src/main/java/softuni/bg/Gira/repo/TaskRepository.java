package softuni.bg.Gira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Gira.model.dto.TaskDTO;
import softuni.bg.Gira.model.entity.Task;
import softuni.bg.Gira.model.entity.User;
import softuni.bg.Gira.model.view.TaskHomeViewModel;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByUser(User optUser);
//    Task findByEmail(String email);
}
