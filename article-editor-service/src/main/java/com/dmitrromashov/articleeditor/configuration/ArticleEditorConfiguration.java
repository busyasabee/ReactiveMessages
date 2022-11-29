package com.dmitrromashov.articleeditor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

@Configuration
@EnableAsync
public class ArticleEditorConfiguration {
    @Bean
    public ThreadPoolExecutor articleThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                6,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        return threadPoolExecutor;
    }
}
