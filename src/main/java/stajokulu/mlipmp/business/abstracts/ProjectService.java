package stajokulu.mlipmp.business.abstracts;

import java.util.List;
import java.util.UUID;

import stajokulu.mlipmp.entities.concretes.Project;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;

public interface ProjectService {

    List<Project> getAll(); //DONE
    Project getById(UUID id); //DONE
    void saveProject(ProjectCreateDto projectDto); //DONE
    boolean deleteProject(UUID id); //DONE
    Project updateProject(ProjectCreateDto projectDto); //TODO: Implement this method

}
