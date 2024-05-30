package com.ospl.__student.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_crud")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int id;
    @Column(name = "sname",nullable = false)
    private String name;
    @Column(name = "srollno",nullable = false,updatable = false,unique = true)
    private long rollNo;
}
