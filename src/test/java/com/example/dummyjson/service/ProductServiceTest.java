package com.example.dummyjson.service;
import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    private WebTestClient webTestClient;

    @BeforeEach
    public void setup() {
        webTestClient = WebTestClient.bindToServer().baseUrl("https://dummyjson.com").build();
    }

    @Test
    public void testGetAllProducts() {

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Essence Mascara Lash Princess");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Eyeshadow Palette with Mirror");
        List<Product> expectedProducts = Arrays.asList(product1);
        // Mocking response using WebTestClient

        webTestClient.get().uri("/products")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json;charset=UTF-8")
                .expectBodyList(ProductResponse.class)
                .consumeWith(response -> {
                    List<ProductResponse> result = response.getResponseBody();
                    assertEquals(expectedProducts.size(), result.size());
                    assertEquals(expectedProducts.get(0).getTitle(), result.get(0).getTitle());
                });
    }

    @Test
    public void testGetProductById() {

        Product product = new Product();
        product.setId(1L);
        product.setTitle("Essence Mascara Lash Princess");
        // Mocking response using WebTestClient
        webTestClient.get().uri("/products/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .consumeWith(response -> {
                    Product result = response.getResponseBody();
                    assertEquals(product.getTitle(), result.getTitle());
                });
    }
}