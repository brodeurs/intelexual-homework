package com.project.assignment.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "project_user")
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

    @ManyToMany(mappedBy = "users")
    private Set<Project> projects = new HashSet<>();


}
