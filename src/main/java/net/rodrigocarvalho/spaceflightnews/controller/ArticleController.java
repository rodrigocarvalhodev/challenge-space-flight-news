package net.rodrigocarvalho.spaceflightnews.controller;

import net.rodrigocarvalho.spaceflightnews.model.Article;
import net.rodrigocarvalho.spaceflightnews.repository.ArticleRepository;
import net.rodrigocarvalho.spaceflightnews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Article save(@RequestBody @Valid Article article) {
        return this.articleService.insert(article);
    }

    @GetMapping
    public List<Article> getAll() {
        return this.articleService.list();
    }

    @GetMapping("{page}/{size}")
    public List<Article> getAllPage(@PathVariable int page, @PathVariable int size) {
        return this.articleService.listPagineable(page-1, size).getContent();
    }

    @GetMapping("{id}")
    public Article getById(@PathVariable String id) {
        return this.articleService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with id " + id + " not found"));
    }

    @PutMapping ("{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid Article article) {
        this.articleService.save(article);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.articleService.deleteById(id);
    }
}