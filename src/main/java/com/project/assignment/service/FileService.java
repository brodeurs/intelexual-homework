package com.project.assignment.service;

import com.project.assignment.entity.File;
import com.project.assignment.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    Set<File> saveFiles(Set<File> fileDtos) {

        List<File> files = fileRepository.saveAll(fileDtos);

        Set<File> filesSet = files.stream().collect(Collectors.toSet());;

        return filesSet;
    }


}
