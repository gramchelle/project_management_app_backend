package stajokulu.mlipmp.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.TaskService;
import stajokulu.mlipmp.entities.concretes.Task;
import stajokulu.mlipmp.entities.dto.task.TaskDto;
import stajokulu.mlipmp.entities.dto.task.TaskSaveDto;
import stajokulu.mlipmp.repository.*;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTask(TaskSaveDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setProjectId(projectRepository.findById(taskDto.getProjectId()).orElse(null));
        task.setAssigneeId(userRepository.findById(taskDto.getAssigneeId()).orElse(null));
        taskRepository.save(task);
    }

    @Override
    public boolean deleteTask(UUID id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Task updateTask(TaskSaveDto taskDto, UUID id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setProjectId(projectRepository.findById(taskDto.getProjectId()).orElse(null));
            task.setAssigneeId(userRepository.findById(taskDto.getAssigneeId()).orElse(null));
            taskRepository.save(task);
        }
        return task;
    }

}
