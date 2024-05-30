package com.ospl.__product.service;

import com.ospl.__product.dto.Product;
import com.ospl.__product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ResponseEntity<Product> addProduct(Product product){
        Product saveProduct = repository.save(product);
        if (saveProduct!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(saveProduct);
    }

    public ResponseEntity<Product> getProduct(int id){
        Optional<Product> opt = repository.findById(id);
        if (opt.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(opt.get());
    }

    public ResponseEntity<Product> updateProduct(Product product){
        Product saveProduct = repository.save(product);
        if (saveProduct.equals(product)){
            return ResponseEntity.status(HttpStatus.OK).body(saveProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(saveProduct);
    }

    public ResponseEntity<Product> updateProductPriceById(double price, int id){
        Product product = repository.findById(id).get();
        product.setPrice(price);
        Product saveProduct = repository.save(product);
        if (saveProduct.getPrice()==price){
            return ResponseEntity.status(HttpStatus.OK).body(saveProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }

    public ResponseEntity<Product> getProductByName(String name){
        Optional<Product> opt = repository.findByName(name);
        if (opt.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(opt.get());
    }

    public ResponseEntity<String> deleteProduct(int id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }

    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = repository.findAll();
        if (products!=null){
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }

    public ResponseEntity<String> deleteAllProducts(){
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Deleted All Products");
    }
}
