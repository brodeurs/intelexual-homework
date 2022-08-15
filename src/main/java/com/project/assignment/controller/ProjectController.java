package com.project.assignment.controller;

import com.project.assignment.dto.ProjectDto;
import com.project.assignment.entity.Project;
import com.project.assignment.repo.ProjectRepository;
import com.project.assignment.service.ProjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    List<ProjectDto> all(@RequestParam(defaultValue = "0") Integer pageNo,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         @RequestParam(defaultValue = "id") String sortBy) {

        pageNo = pageNo > 0 ? pageNo-- : pageNo;
        return projectService.getProjects(pageNo, pageSize, sortBy);
    }

    @PostMapping("/projects")
    ProjectDto newProject(@RequestBody ProjectDto newProject) {
        return projectService.saveProject(newProject);
    }
}
