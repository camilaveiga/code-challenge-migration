package com.example.dummyjson.service;
import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;


@Service
public class ProductService {
    private final String BASE_URL = "https://dummyjson.com/products";

    @Autowired
    private WebClient webClient;

    public List<Product> getAllProducts() {
        
        return webClient.get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .map(ProductResponse::getProducts)
                .block(); 
    }
    
    public Product getProductById(Long id) {
        String url = BASE_URL + "/" + id;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Product.class)
                .block(); 
    }
}