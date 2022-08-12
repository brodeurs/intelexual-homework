package com.project.assignment.service;

import com.project.assignment.dto.FileDto;
import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    Set<File> getFilesById(Set<Long> userIds) {

        List<File> files = fileRepository.findAllById(userIds);

        Set<File> filesSet = files.stream().collect(Collectors.toSet());

        return filesSet;
    }

    Set<File> saveFiles(Project savedProject, Set<FileDto> fileDtos) {

        Set<File> fileSet = fileDtos.stream()
                .map(userDto -> new File(userDto.getName(), userDto.getFileType()))
                .collect(Collectors.toSet());

        fileSet.stream().forEach(f-> {
            f.setProject(savedProject);
        });
        List<File> savedfiles = fileRepository.saveAll(fileSet);

        Set<File> savedFilesSet = savedfiles.stream().collect(Collectors.toSet());;

        return savedFilesSet;
    }


}
