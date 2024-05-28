package softuni.bg.Gira.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.Gira.model.annotation.StringDateInFuture;
import softuni.bg.Gira.model.enums.ClassificationName;

@Getter
@Setter
public class TasksAddBindingModel {
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @Size(min = 1, message = "The date cannot be in the past!!")
    @StringDateInFuture
    private String dueDate;

    @NotNull(message = "Classification cannot be null!")
    private ClassificationName classification;
}
