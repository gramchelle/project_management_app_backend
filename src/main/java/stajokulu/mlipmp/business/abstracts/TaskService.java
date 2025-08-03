package stajokulu.mlipmp.business.abstracts;

import java.util.List;
import java.util.UUID;

import stajokulu.mlipmp.entities.concretes.Task;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.entities.dto.task.TaskDto;

public interface TaskService {

    List<Task> getAll(); //TODO: Implement this method
    Task getById(UUID id); //TODO: Implement this method
    void saveTask(TaskDto taskDto); //TODO: Implement this method
    boolean deleteTask(UUID id); //TODO: Implement this method
    Task updateTask(TaskDto taskDto); //TODO: Implement this method
}
