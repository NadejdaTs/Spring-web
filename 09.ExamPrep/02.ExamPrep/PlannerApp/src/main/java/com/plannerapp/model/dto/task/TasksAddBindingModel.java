package com.plannerapp.model.dto.task;

import com.plannerapp.model.annotation.StringDateInFuture;
import com.plannerapp.model.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class TasksAddBindingModel {
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @StringDateInFuture(message = "Due date must be in the future!")
    private String dueDate;

    @NotNull(message = "You must select a priority!")
    private PriorityName priority;

}
