package stajokulu.mlipmp.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ProjectService;
import stajokulu.mlipmp.entities.concretes.Project;
import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.repository.ProjectRepository;
import stajokulu.mlipmp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Override
    public void saveProject(ProjectCreateDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());

        User owner = userRepository.findById(projectDto.getOwnerId())
            .orElseThrow(() -> new RuntimeException("User not found"));
        project.setOwner(owner);

        projectRepository.save(project);
    }

    @Override
    public boolean deleteProject(UUID id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override //TODO: Implement this method
    public Project updateProject(ProjectCreateDto projectDto) {
        return null;
    }

}
