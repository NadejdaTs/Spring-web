package com.plannerapp.model.dto.task;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private String description;
    private String dueDate;
    private PriorityName priority;

    public static TaskDTO createFromTask(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriority(task.getPriority().getName());
        taskDTO.setDueDate(task.getDueDate().toString());
        return taskDTO;
    }
}
