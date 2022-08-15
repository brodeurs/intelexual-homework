package com.project.assignment.repo;

import com.project.assignment.entity.File;
import com.project.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface FileRepository extends JpaRepository<File, Long> {

    @Query(value = "select  p.files from Project p join p.files f  where p.id=:project_id")
    Set<File> findFilesByProjectId(@Param("project_id") Long project_id);

}
