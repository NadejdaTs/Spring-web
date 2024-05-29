package softuni.bg.Gira.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.Gira.model.binding.TasksAddBindingModel;
import softuni.bg.Gira.model.dto.TaskDTO;
import softuni.bg.Gira.model.entity.Classification;
import softuni.bg.Gira.model.entity.Task;
import softuni.bg.Gira.model.entity.User;
import softuni.bg.Gira.model.enums.ClassificationName;
import softuni.bg.Gira.model.enums.Progress;
import softuni.bg.Gira.model.view.TaskHomeViewModel;
import softuni.bg.Gira.repo.ClassificationRepository;
import softuni.bg.Gira.repo.TaskRepository;
import softuni.bg.Gira.repo.UserRepository;
import softuni.bg.Gira.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ClassificationRepository classificationRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public TaskServiceImpl(TaskRepository taskRepository, ClassificationRepository classificationRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.taskRepository = taskRepository;
        this.classificationRepository = classificationRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void add(TasksAddBindingModel tasksAddBindingModel) {
        String name = tasksAddBindingModel.getClassification().name();
        Classification classification = this.classificationRepository.findByName(tasksAddBindingModel.getClassification());

        Task task = new Task();
        if(classification != null){
            User user = this.userRepository.findByEmail(this.loggedUser.getEmail());

            task.setName(tasksAddBindingModel.getName());
            task.setDescription(tasksAddBindingModel.getDescription());
            task.setDueDate(LocalDate.parse(tasksAddBindingModel.getDueDate()));
            task.setClassification(classification);
            task.setProgress(Progress.OPEN);
            task.setUser(user);

            this.taskRepository.save(task);
        }
    }

    @Override
    public TaskHomeViewModel getHomeViewData(String email) {
        User optUser = this.userRepository.findByEmail(email);

        List<TaskDTO> taskList = this.taskRepository.findByUser(optUser).stream()
                .map(TaskDTO::createFromTask)
                .toList();

        return new TaskHomeViewModel(taskList);
    }

    @Override
    public void progress(String id, String email) {
        User optUser = this.userRepository.findByEmail(email);

        Optional<Task> optTask = this.taskRepository.findById(id);
        if(optTask.isPresent()){
            switch(optTask.get().getProgress()){
                case OPEN:
                    optTask.get().setProgress(Progress.IN_PROGRESS);
                    this.taskRepository.save(optTask.get());
                    break;
                case IN_PROGRESS:
                    optTask.get().setProgress(Progress.COMPLETED);
                    this.taskRepository.save(optTask.get());
                    break;
                case COMPLETED:
                    this.taskRepository.delete(optTask.get());
                    break;
            }
        }
    }
}
