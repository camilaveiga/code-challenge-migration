package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productController.getAllProducts();
    }
    
    @Test
    public void testGetProductById() {
        Product product = productController.getProductById(1L);
    }
}