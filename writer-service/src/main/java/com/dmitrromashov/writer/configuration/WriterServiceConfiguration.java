package com.dmitrromashov.writer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WriterServiceConfiguration {
    private final String urlForArticles = "http://localhost:8082";

    @Bean
    public WebClient webClient() {
        return WebClient.create(urlForArticles);
    }
}
