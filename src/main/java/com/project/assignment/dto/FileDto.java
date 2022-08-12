package com.project.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import lombok.Data;

//@Data
public class FileDto {

    private String name;
    private String fileType;
    @JsonIgnore
    private ProjectDto project;

    public FileDto() {

    }

    public FileDto(File file) {

        this.name = file.getName();
        this.fileType = file.getFileType();
//        ProjectDto projectDto = new ProjectDto(project);
//        this.project = projectDto;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
