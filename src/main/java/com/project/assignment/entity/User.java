package com.project.assignment.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "project_user")
public class User {

    public User() {
    }
    //    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

}
