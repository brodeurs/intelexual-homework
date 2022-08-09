package com.project.assignment.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class User {

    public User() {
    }
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @Column(name = "email_address", nullable = false)
    @NonNull
    private String emailAddress;

    @ManyToMany(targetEntity = Project.class)
    private Collection<Project> projects = new ArrayList<>();
}
