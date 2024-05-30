package com.ospl.__project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_crud")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid",unique = true)
    private int id;
    @Column(name = "pname",nullable = false,unique = true)
    private String name;
    private String description;
    @Column(name = "Startingdate",updatable = false,nullable = false)
    private Date startDate;
    @Column(name = "endingdate")
    private Date endDate;
}
