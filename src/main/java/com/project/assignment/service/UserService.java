package com.project.assignment.service;

import com.project.assignment.dto.UserDto;
import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Set<User> saveUsers(Project savedProject, List<UserDto> userDtos) {

        Set<User> usersSet = userDtos.stream()
                .map(userDto -> new User(userDto.getName(), userDto.getEmailAddress()))
                .collect(Collectors.toSet());

        usersSet.stream().forEach(user -> {
            user.addProject(savedProject);
        });
        List<User> users = userRepository.saveAll(usersSet);


        usersSet = users.stream().collect(Collectors.toSet());

        return usersSet;
    }
}
