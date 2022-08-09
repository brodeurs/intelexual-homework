package com.project.assignment.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Set;

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

    @OneToMany(targetEntity = User.class)
    private Set<User> users;

    protected Project() {}

    public Project(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}
