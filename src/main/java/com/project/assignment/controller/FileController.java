package com.project.assignment.controller;

import com.project.assignment.entity.File;
import com.project.assignment.entity.User;
import com.project.assignment.repo.FileRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class FileController {

    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/files")
    List<File> all() {
        return fileRepository.findAll();
    }

    @PostMapping("/files")
    File newFile(@RequestBody File newFile) {
        return fileRepository.save(newFile);
    }

}
