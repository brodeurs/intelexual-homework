package com.project.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.project.assignment.repo")
@SpringBootApplication
public class ProjectsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsAppApplication.class, args);
    }

}
