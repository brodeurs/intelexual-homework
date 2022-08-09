package com.project.assignment.repo;

import com.project.assignment.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
