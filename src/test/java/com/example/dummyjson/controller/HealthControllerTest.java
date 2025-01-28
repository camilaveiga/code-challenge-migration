package com.example.dummyjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;



@SpringBootTest
@AutoConfigureMockMvc
public class HealthControllerTest {

    @Autowired
    private WebTestClient webTestClient;
  
    @Test
    public void testHealthCheck() {
    
    webTestClient.get()
                .uri("/api/products/health")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");
    } 
               
}
