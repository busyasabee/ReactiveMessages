package com.dmitrromashov.articleeditor.services;

import com.dmitrromashov.common.model.Article;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class ArticleEditor {
    @SneakyThrows
    public void editArticle(Article article) {
        Thread.sleep(100);
    }
}
