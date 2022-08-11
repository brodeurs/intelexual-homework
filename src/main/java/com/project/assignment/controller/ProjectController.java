package com.project.assignment.controller;

import com.project.assignment.entity.Project;
import com.project.assignment.repo.ProjectRepository;
import com.project.assignment.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    List<Project> all() {
        return projectService.getProjects();
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return projectService.saveProject(newProject);
    }
}
