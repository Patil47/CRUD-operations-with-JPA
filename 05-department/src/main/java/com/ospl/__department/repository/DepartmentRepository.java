package com.ospl.__department.repository;

import com.ospl.__department.dto.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    public Optional<Department> getDepartmentByName(String name);
    public void deleteDepartmentByName(String name);
}
