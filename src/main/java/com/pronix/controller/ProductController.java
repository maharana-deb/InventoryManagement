package com.pronix.controller;

import com.pronix.entity.Product;
import com.pronix.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public Product saveProduct(@Valid @RequestBody Product product){
        return productServiceImpl.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productServiceImpl.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product){
        return productServiceImpl.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productServiceImpl.deleteProductById(id);
    }

}