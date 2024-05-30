package com.ospl.__department.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_crud")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did",unique = true)
    private int id;
    @Column(name = "dname",unique = true,nullable = false,updatable = false)
    private String name;
    @Column(name = "dlocation",nullable = false)
    private String location;
}
