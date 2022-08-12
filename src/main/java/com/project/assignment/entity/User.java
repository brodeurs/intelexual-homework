package com.project.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

//@Data
@RequiredArgsConstructor
@Entity
@Table(name = "project_user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    public User() {
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

//    @ManyToMany(targetEntity = Project.class, mappedBy = "users",
//            cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
//    private Set<Project> projects = new HashSet<>();


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
}
