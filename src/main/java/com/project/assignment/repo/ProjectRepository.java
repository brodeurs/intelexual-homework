package com.project.assignment.repo;

import com.project.assignment.entity.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

//@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
