package com.example.dummyjson.config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebClientConfigTest {
    @Autowired
    private WebClientConfig webClientConfig;

    @Test
    public void testWebClientConfig() {
        assertNotNull(webClientConfig.webClient());
    }
}