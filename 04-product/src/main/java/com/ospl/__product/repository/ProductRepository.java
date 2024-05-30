package com.ospl.__product.repository;

import com.ospl.__product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
    void deleteByName(String name);
}
