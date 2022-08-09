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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "file")
public class File {

    public File() {}

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(name = "file_type", nullable = false)
    private String fileType;

    @ManyToOne
    private Project project;
}
