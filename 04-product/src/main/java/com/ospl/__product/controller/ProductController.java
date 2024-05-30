package com.ospl.__product.controller;

import com.ospl.__product.dto.Product;
import com.ospl.__product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    //Add Product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    //View Product by Product Id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    //View Product by Product Name
    @GetMapping("/name/{id}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    //Update Product
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    //Update Product price by Product id
    @PutMapping("/price/{id}")
    public ResponseEntity<Product> updateProductPriceById(@RequestParam double price, @PathVariable int id){
        return service.updateProductPriceById(price,id);
    }

    //Remove Product by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    //View All Products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return service.getAllProducts();
    }

    //Removed All Products
    public ResponseEntity<String> deleteAllProducts(){
        return service.deleteAllProducts();
    }

}
