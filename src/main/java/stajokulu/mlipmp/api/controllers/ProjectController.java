package stajokulu.mlipmp.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ProjectService;
import stajokulu.mlipmp.entities.concretes.Project;
import stajokulu.mlipmp.entities.dto.project.ProjectCreateDto;
import stajokulu.mlipmp.entities.dto.project.ProjectUpdateDto;

@CrossOrigin(origins = "http://localhost:3000")
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

}
