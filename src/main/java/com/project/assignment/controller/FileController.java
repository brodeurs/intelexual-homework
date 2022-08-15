package com.project.assignment.controller;

import com.project.assignment.dto.FileDto;
import com.project.assignment.service.FileService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/filesByProjectId")
    List<FileDto> findFilesByProjectId(@RequestParam Long projectId) {
        System.out.println("projectId: " + projectId);

        List<FileDto> files = fileService.findUsersByProjectId(projectId);
        return files;
    }

}
