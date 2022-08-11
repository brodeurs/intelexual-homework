package com.project.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.project.assignment.repo")
@SpringBootApplication
public class ProjectsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsAppApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(ProjectRepository projectRepository, UserRepository userRepository, FileRepository fileRepository) {
//        return (args) -> {
//            // save a few customers
//
//            Project project = new Project("first", new Date(Calendar.getInstance().getTimeInMillis()));
//
//            projectRepository.save(project);
//
//            User user = new User("Bilbo Baggins", "a@b.com");
//            File file = new File("My File", "Text");
//
//            userRepository.save(user);
//            fileRepository.save(file);
//
//            project.getUsers().add(user);
//            project.getFiles().add(file);
//
//            projectRepository.save(project);
//
//        };
//    }

}
