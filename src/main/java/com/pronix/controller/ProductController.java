package com.pronix.controller;

import com.pronix.entity.Product;
import com.pronix.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@Valid @RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

}