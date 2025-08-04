package stajokulu.mlipmp.business.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.servlet.HttpConstraintElement;
import jakarta.servlet.ServletRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ProjectService;
import stajokulu.mlipmp.entities.concretes.Project;
import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.entities.dto.project.ProjectUpdateDto;
import stajokulu.mlipmp.repository.ProjectRepository;
import stajokulu.mlipmp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ServletRequest httpServletRequest;

    @Override
    public List<Project> getAll() {
        //httpServletRequest req = new HttpConstraintElement()
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

    @Override
    public boolean updateProject(ProjectUpdateDto projectUpdateDto) {
        Project project = projectRepository.findById(projectUpdateDto.getId())
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectUpdateDto.getId()));

        project.setName(projectUpdateDto.getName());
        project.setStartDate(projectUpdateDto.getStartDate());
        project.setEndDate(projectUpdateDto.getEndDate());

        projectRepository.save(project);
        return true;
    }

    @Override
    public List<Project> getByUserId(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return projectRepository.findByOwner(user);
    }

}
