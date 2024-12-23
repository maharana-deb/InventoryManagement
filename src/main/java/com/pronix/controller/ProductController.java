package com.pronix.controller;

import com.pronix.entity.Product;
import com.pronix.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
        Product savedProduct = productServiceImpl.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Product product = productServiceImpl.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product){
        Product updatedProduct = productServiceImpl.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        String message = productServiceImpl.deleteProductById(id);
        return ResponseEntity.ok(message);
    }

}