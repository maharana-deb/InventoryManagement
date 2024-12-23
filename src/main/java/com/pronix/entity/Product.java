package com.pronix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name can not be null. Please check.")
    @NotBlank(message = "Product name can not be blank. Please check.")
    private String name;

    @NotNull(message = "Product brand can not be null. Please check.")
    @NotBlank(message = "Product brand can not be blank. Please check.")
    private String brand;

    @NotNull(message = "Product category can not be null. Please check.")
    @NotBlank(message = "Product category can not be blank. Please check.")
    private String category;

    @NotNull(message = "Product price can not be null. Please check.")
    @Positive(message = "Product price should be a positive number only. Please check.")
    private Double price;

    @NotNull(message = "Product quantity can not be null. Please check.")
    @Positive(message = "Product quantity should be a positive number only. Please check.")
    private Integer quantity;

}
