package stajokulu.mlipmp.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ProjectService;
import stajokulu.mlipmp.entities.concretes.Project;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.entities.dto.project.ProjectDescriptionDto;
import stajokulu.mlipmp.entities.dto.project.ProjectUpdateDto;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/getAll")
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Project getProjectById(@PathVariable UUID id) {
        return projectService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteProject(@PathVariable UUID id){
        return projectService.deleteProject(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> createProject(@RequestBody ProjectCreateDto projectDto) {
        projectService.saveProject(projectDto);
        return ResponseEntity.ok("Project created successfully.");
    }

    @PutMapping("/updateProject")
    public ResponseEntity<String> updateProject(@RequestBody ProjectUpdateDto projectUpdateDto){
        boolean isUpdated = projectService.updateProject(projectUpdateDto);
        if (isUpdated) {
            return ResponseEntity.ok("Project updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByUserId/{userId}")
    public List<Project> getProjectsByUserId(@PathVariable UUID userId) {
        return projectService.getByUserId(userId);
    }

    /*@GetMapping("/getDescription/{id}")
    public List<ProjectDescriptionDto> getProjectDescription(@PathVariable UUID id) {
        return projectService.getDescription(id);
    }*/

}
