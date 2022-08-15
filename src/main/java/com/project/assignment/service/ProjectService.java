package com.project.assignment.service;

import com.project.assignment.dto.FileDto;
import com.project.assignment.dto.ProjectDto;
import com.project.assignment.dto.UserDto;
import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<ProjectDto> getProjects(Integer pageNo, Integer pageSize, String sortBy) {
        List<Project> projects;

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Project> pagedResult = projectRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            projects = pagedResult.getContent();
        } else {
            projects = new ArrayList<>();
        }
//        projects = projectRepository.findAll();

//        List<ProjectDto> projectDtos = new ArrayList<>();

        List<ProjectDto> projectDtos = projects.stream()
        .map(project -> new ProjectDto(project))
        .collect(Collectors.toList());


        return projectDtos;
    }

    public ProjectDto saveProject(ProjectDto projectDto) {


            Project savedProject = new Project(projectDto.getName(), projectDto.getStartDate());

            savedProject = projectRepository.save(savedProject);

            Set<UserDto> userDtoSet = new HashSet<>();
            userDtoSet.addAll(projectDto.getUsers());
            Set<User> users = userService.saveUsers(savedProject, projectDto.getUsers());
            savedProject.getUsers().addAll(users);

//            savedProject = projectRepository.save(savedProject);

            Set<FileDto> fileDtoSet = new HashSet<>();
            fileDtoSet.addAll(projectDto.getFiles());
            Set<File> files = fileService.saveFiles(savedProject, projectDto.getFiles());

            savedProject.getFiles().addAll(files);
            savedProject = projectRepository.save(savedProject);
//
            projectDto = new ProjectDto(savedProject);

        return projectDto;

    }
}
