package com.project.assignment.service;

import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.FileRepository;
import com.project.assignment.repo.ProjectRepository;
import com.project.assignment.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectService {


    private ProjectRepository projectRepository;


    private UserService userService;

    private FileService fileService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserService userService, FileService fileService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
        this.fileService = fileService;
    }

    public List<Project> getProjects() {
        List<Project> projects;

        projects = projectRepository.findAll();


        return projects;
    }

    public Project saveProject(Project projectDto) {


            Project project = new Project(projectDto.getName(), projectDto.getStartDate());

            projectRepository.save(project);

            Set<User> users = userService.saveUsers(projectDto.getUsers());

            project.getUsers().addAll(users);

            Set<File> files = fileService.saveFiles(projectDto.getFiles());

            project.getFiles().addAll(files);

            projectRepository.save(project);

        return project;

    }
}
