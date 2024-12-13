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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
