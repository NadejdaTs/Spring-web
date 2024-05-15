package com.plannerapp.model.dto.task;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskHomeViewModel {
    private List<TaskDTO> assignedTasksToMe;
    private List<TaskDTO> availableTasks;

    public TaskHomeViewModel(){
        assignedTasksToMe = new ArrayList<>();
        availableTasks = new ArrayList<>();
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasksToMe, List<TaskDTO> availableTasks) {
        this();
    }
}
