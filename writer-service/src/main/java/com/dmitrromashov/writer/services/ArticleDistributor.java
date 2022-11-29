package com.dmitrromashov.writer.services;

import com.dmitrromashov.common.model.Article;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleDistributor {
    private final ArticleSender articleSender;
    private final ArticleWriter articleWriter;

    public ArticleDistributor(ArticleSender articleSender,
                              ArticleWriter articleWriter) {
        this.articleSender = articleSender;
        this.articleWriter = articleWriter;
    }

    @EventListener(ApplicationStartedEvent.class)
    @SneakyThrows
    public void distributeArticles() {
        while (true) {
            Thread.sleep(10);
            distributeArticle();
        }
    }

    public void distributeArticle() {
        Article article = articleWriter.writeArticle();
        log.info("Sending article " + article);
        articleSender.send(article);
    }
}

