package com.project.assignment.repo;

import com.project.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select  p.users from Project p join p.users u  where p.id=:project_id")
    Set<User> findUsersByProjectId(@Param("project_id") Long project_id);

}
