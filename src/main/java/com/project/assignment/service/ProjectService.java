package com.project.assignment.service;

import com.project.assignment.dto.FileDto;
import com.project.assignment.dto.ProjectDto;
import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.FileRepository;
import com.project.assignment.repo.ProjectRepository;
import com.project.assignment.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<ProjectDto> getProjects() {
        List<Project> projects;

        projects = projectRepository.findAll();

//        List<ProjectDto> projectDtos = new ArrayList<>();

        List<ProjectDto> projectDtos = projects.stream()
        .map(project -> new ProjectDto(project))
        .collect(Collectors.toList());


        return projectDtos;
    }

    public ProjectDto saveProject(ProjectDto projectDto) {


            Project savedProject = new Project(projectDto.getName(), projectDto.getStartDate());

            savedProject = projectRepository.save(savedProject);

//            Set<User> users = userService.saveUsers(projectDto.getUsers());

//            savedProject.getUsers().addAll(users);

            Set<FileDto> fileDtoSet = new HashSet<>();
            fileDtoSet.addAll(projectDto.getFiles());
            Set<File> files = fileService.saveFiles(savedProject, fileDtoSet);

//            savedProject.getFiles().addAll(files);
            savedProject = projectRepository.save(savedProject);

            projectDto = new ProjectDto(savedProject);

        return projectDto;

    }
}
