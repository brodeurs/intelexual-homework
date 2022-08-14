package com.project.assignment.dto;

import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
public class UserDto {

    private Long id;
    private String name;
    private String emailAddress;
    private List<ProjectDto> projects;

    public UserDto() {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.emailAddress = user.getEmailAddress();
        this.projects = new ArrayList<>();
        for (Project project : user.getProjects()) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(project.getId());
            projectDto.setName(project.getName());
            projectDto.setStartDate(project.getStartDate());
            projects.add(projectDto);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
}
