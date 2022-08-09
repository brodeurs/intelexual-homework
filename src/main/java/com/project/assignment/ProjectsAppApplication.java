package com.project.assignment;

import com.project.assignment.entity.File;
import com.project.assignment.entity.Project;
import com.project.assignment.entity.User;
import com.project.assignment.repo.FileRepository;
import com.project.assignment.repo.ProjectRepository;
import com.project.assignment.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@EnableJpaRepositories("com.project.assignment.repo")
@SpringBootApplication
public class ProjectsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProjectRepository projectRepository, UserRepository userRepository, FileRepository fileRepository) {
        return (args) -> {
            // save a few customers

            Project project = new Project("first", new Date(Calendar.getInstance().getTimeInMillis()));

            projectRepository.save(project);

            User user = new User("Bilbo Baggins", "a@b.com");
            File file = new File("My File", "Text");

            userRepository.save(user);
            fileRepository.save(file);

            project.getUsers().add(user);
            project.getFiles().add(file);

            projectRepository.save(project);

        };
    }

}
