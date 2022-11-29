package com.dmitrromashov.writer.services;

import com.dmitrromashov.common.model.Article;
import org.springframework.stereotype.Service;

@Service
public class ArticleWriter {
    private Long counter = 0L;

    public Article writeArticle() {
        counter += 1;
        return new Article("title" + counter, "authorName" + counter, "content" + counter);
    }
}
