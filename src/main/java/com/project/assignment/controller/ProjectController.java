package com.project.assignment.controller;

import com.project.assignment.entity.Project;
import com.project.assignment.repo.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;

    ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    List<Project> all() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return projectRepository.save(newProject);
    }
}
