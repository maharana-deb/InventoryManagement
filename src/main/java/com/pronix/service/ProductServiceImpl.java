package com.pronix.service;

import com.pronix.entity.Product;
import com.pronix.exception.BadRequestException;
import com.pronix.exception.ResourceNotFoundException;
import com.pronix.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id) {

        if(id == null || id.trim().isEmpty() || !id.matches("\\d+")){
            throw new BadRequestException("Invalid product id, the id should be a number only.");
        }
        return productRepository.findById(Long.valueOf(id))
                                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find any product with the provided product id."));
    }

    public Product updateProduct(Long id, Product newProduct){

        Product product = productRepository.findById(id).orElse(null);
        
        if(product == null){
            throw new ResourceNotFoundException("Couldn't find any product with the provided product id.");
        } else {
            product.setName(newProduct.getName());
            product.setBrand(newProduct.getBrand());
            product.setCategory(newProduct.getCategory());
            product.setPrice(newProduct.getPrice());
            product.setQuantity(newProduct.getQuantity());
            return productRepository.save(product);
        }

    }
    
    public String deleteProductById(Long id){

        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Couldn't find any product with the provided product id.");
        } else {
            productRepository.deleteById(id);
            return "Product removed from Database!";
        }

    }

}
