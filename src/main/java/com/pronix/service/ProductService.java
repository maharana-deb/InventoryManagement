package com.pronix.service;

import com.pronix.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product updateProduct(Long id, Product newProduct);
    String deleteProductById(Long id);

}
