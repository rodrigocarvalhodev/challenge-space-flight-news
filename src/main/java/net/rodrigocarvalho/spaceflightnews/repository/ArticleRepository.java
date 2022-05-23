package net.rodrigocarvalho.spaceflightnews.repository;

import net.rodrigocarvalho.spaceflightnews.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

    
}
