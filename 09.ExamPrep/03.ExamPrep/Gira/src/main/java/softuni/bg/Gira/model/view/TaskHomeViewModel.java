package softuni.bg.Gira.model.view;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.Gira.model.dto.TaskDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskHomeViewModel {
    private List<TaskDTO> tasks;

    public TaskHomeViewModel() {
        this.tasks = new ArrayList<>();
    }

    public TaskHomeViewModel(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
