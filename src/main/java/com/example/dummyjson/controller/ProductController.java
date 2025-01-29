package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nonnull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    @Operation(summary = "Get all products", description = "Retorna todos os produtos da API")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id", description = "Retorna um produto da API pelo ID")
    public Product getProductById(@PathVariable @Nonnull Long id) {
        return productService.getProductById(id);
    }

    
}