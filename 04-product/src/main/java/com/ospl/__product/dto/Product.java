package com.ospl.__product.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_crud")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid",unique = true)
    private int id;
    @Column(name = "pname",unique = true,nullable = false)
    private String name;
    @Column(name = "pprice",updatable = true,nullable = false)
    private double price;
    private Date purchaseDate;
}
