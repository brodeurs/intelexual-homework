package com.project.assignment.dto;

import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//@Data
public class ProjectDto {

    private Long id;

    private String name;

    private Date startDate;

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public List<FileDto> getFiles() {
        return files;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public void setFiles(List<FileDto> files) {
        this.files = files;
    }

    private List<UserDto> users = new ArrayList<>();
    private List<FileDto> files = new ArrayList<>();

    public ProjectDto() {

    }

    public ProjectDto(Project project) {
        this.setId(project.getId());
        this.name = project.getName();
        this.startDate = project.getStartDate();

        for (User user : project.getUsers()) {
            UserDto userDto = new UserDto(user);
            users.add(userDto);
        }

        for (File file : project.getFiles()) {
            FileDto fileDto = new FileDto(file);
            files.add(fileDto);
        }
    }
}
