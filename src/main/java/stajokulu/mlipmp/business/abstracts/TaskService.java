package stajokulu.mlipmp.business.abstracts;

import java.util.List;
import java.util.UUID;

import stajokulu.mlipmp.entities.concretes.Task;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.entities.dto.task.TaskDto;

public interface TaskService {

    List<Task> getAll(); //DONE
    Task getById(UUID id); //DONE
    void saveTask(TaskDto taskDto); //DONE
    boolean deleteTask(UUID id); //TODO: Implement this method
    Task updateTask(TaskDto taskDto); //DONE
}
