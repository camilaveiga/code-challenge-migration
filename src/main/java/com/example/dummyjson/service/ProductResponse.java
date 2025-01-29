package com.example.dummyjson.service;

import java.util.List;

import com.example.dummyjson.dto.Product;

public class ProductResponse {
    private List<Product> products;  

    
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Object getTitle() {
        return products.get(0).getTitle();
    }
}