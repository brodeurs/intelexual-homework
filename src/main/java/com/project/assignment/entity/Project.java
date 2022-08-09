package com.project.assignment.entity;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@Table(name = "project")
public class Project {

//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @ManyToMany(targetEntity = User.class)
//    @JoinTable(
//            name = "projects_users",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    private Collection<User> users = new ArrayList<>();

    protected Project() {}

    public Project(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}
