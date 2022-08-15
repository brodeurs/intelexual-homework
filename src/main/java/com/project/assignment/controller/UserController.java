package com.project.assignment.controller;

import com.project.assignment.dto.UserDto;
import com.project.assignment.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/usersByProjectId")
    List<UserDto> findUsersByProjectId(@RequestParam Long projectId) {
        System.out.println("projectId: " + projectId);
        return userService.findUsersByProjectId(projectId);
    }

 }
