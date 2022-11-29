# ReactiveMessages

Application for testing and comparing different approaches to working with big load between several services.

Services:

1. writer-service - send articles to article-editor-service
2. article-editor-service - edit articles and then send them to publisher-service
3. publisher-service - publish articles


Branches:
1. first_approach - article-editor-service use @Async and thread pool for handling incoming article 