package softuni.bg.Gira.model.dto;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.Gira.model.entity.Task;
import softuni.bg.Gira.model.enums.ClassificationName;
import softuni.bg.Gira.model.enums.Progress;

@Getter
@Setter
public class TaskDTO {
    private String id;
    private String name;
    private String assignedTo;
    private ClassificationName classification;
    private String dueDate;
    private Progress progress;

    public static TaskDTO createFromTask(Task task){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setClassification(task.getClassification().getName());
        taskDTO.setProgress(task.getProgress());
        taskDTO.setDueDate(task.getDueDate().toString());
        taskDTO.setAssignedTo(task.getUser().getUsername());

        return taskDTO;
    }
}
