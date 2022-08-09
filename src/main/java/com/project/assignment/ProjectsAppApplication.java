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

@EnableJpaRepositories("com.project.assignment.repo")
@SpringBootApplication
public class ProjectsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProjectRepository repository, UserRepository userRepository, FileRepository fileRepository) {
        return (args) -> {
            // save a few customers

            Project project = new Project("first", new Date(Calendar.getInstance().getTimeInMillis()));
            User user = new User("Bilbo Baggins", "a@b.com");
            File file = new File("My File", "Text");

            userRepository.save(user);

            project.getUsers().add(user);
            user.getProjects().add(project);


//            fileRepository.save(file);
            repository.save(project);


//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            log.info("");
        };
    }

//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    }
}
