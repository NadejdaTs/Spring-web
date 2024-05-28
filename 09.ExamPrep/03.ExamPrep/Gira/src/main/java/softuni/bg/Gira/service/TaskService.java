package softuni.bg.Gira.service;

import softuni.bg.Gira.model.binding.TasksAddBindingModel;
import softuni.bg.Gira.model.view.TaskHomeViewModel;

public interface TaskService {
    TaskHomeViewModel getHomeViewData(String email);

    void add(TasksAddBindingModel tasksAddBindingModel);

    void progress(String id, String email);
}
