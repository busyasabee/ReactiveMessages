package com.dmitrromashov.articleeditor.controllers;

import com.dmitrromashov.articleeditor.services.ArticleEditor;
import com.dmitrromashov.common.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
@Slf4j
public class ArticleEditorController {
    private final ArticleEditor articleEditor;

    public ArticleEditorController(ArticleEditor articleEditor) {
        this.articleEditor = articleEditor;
    }

    @PostMapping
    @Async("articleThreadPoolExecutor")
    public void editArticle(@RequestBody Article article) {
        log.info("Editing article " + article);
        articleEditor.editArticle(article);
    }
}
