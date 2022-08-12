package com.project.assignment.dto;

import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import lombok.Data;

import java.util.List;

//@Data
public class UserDto {

    private String name;
    private String emailAddress;
    private List<ProjectDto> projects;

    public UserDto() {

    }

    public UserDto(User user) {
        this.name = user.getName();
        this.emailAddress = user.getEmailAddress();
//        for (Project project : user.getProjects()) {
//            ProjectDto projectDto = new ProjectDto(project);
//            projects.add(projectDto);
//        }
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
