package net.rodrigocarvalho.spaceflightnews.service;

import net.rodrigocarvalho.spaceflightnews.model.Article;
import net.rodrigocarvalho.spaceflightnews.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> list() {
        return articleRepository.findAll();
    }

    public Page<Article> listPagineable(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return this.articleRepository.findAll(pageRequest);
    }

    public Article insert(Article article) {
        return this.articleRepository.insert(article);
    }

    public Article save(Article article) {
        return this.articleRepository.save(article);
    }

    public Optional<Article> findById(String id) {
        return this.articleRepository.findById(id);
    }


    public void deleteById(String id) {
        this.articleRepository.deleteById(id);
    }
}
