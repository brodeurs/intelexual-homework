package com.project.assignment.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "file")
public class File {

    public File() {}

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(name = "file_type", nullable = false)
    private String fileType;


}
