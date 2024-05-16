package com.plannerapp.model.dto.task;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskHomeViewModel {
    private List<TaskDTO> assignedTasks;
    private List<TaskDTO> availableTasks;
//    private int availableSize;

    public TaskHomeViewModel(){
        assignedTasks = new ArrayList<>();
        availableTasks = new ArrayList<>();
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasks, List<TaskDTO> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
//        this.availableSize = availableTasks.size();
    }
}
