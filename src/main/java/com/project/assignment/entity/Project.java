package com.project.assignment.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "project_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @OneToMany(targetEntity = File.class)
    private Set<File> files = new HashSet<>();

    protected Project() {}

    public Project(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}
