package com.project.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "project_user")
public class User {

    public User() {
    }

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @Column(name = "email_address", nullable = false)
    @NonNull
    private String emailAddress;

    @ManyToMany(mappedBy = "users")
//    @JsonIgnore
    private Set<Project> projects = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public Set<Project> getProjects() {
        return projects;
    }
}
