package com.ospl.__project.repository;

import com.ospl.__project.dto.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {


    String findByName(String name);
    void deleteByName(String name);
}
