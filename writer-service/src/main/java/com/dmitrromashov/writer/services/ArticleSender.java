package com.dmitrromashov.writer.services;

import com.dmitrromashov.common.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ArticleSender {
    private final WebClient webClient;

    public ArticleSender(WebClient webClient) {
        this.webClient = webClient;
    }

    public void send(Article article) {
        webClient.post()
                .uri("/article")
                .body(Mono.just(article), Article.class)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}

