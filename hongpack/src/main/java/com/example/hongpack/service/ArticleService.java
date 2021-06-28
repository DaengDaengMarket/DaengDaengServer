package com.example.hongpack.service;

import com.example.hongpack.Repository.ArticleRepository;
import com.example.hongpack.dto.ArticleForm;
import com.example.hongpack.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article saveArticle(ArticleForm form){
        Article article = form.toEntity();

        return articleRepository.save(article);
    }

    public List<Article> viewArticle(){
        return articleRepository.findAll();
    }

    public Article getArticle(Long id){
        return articleRepository.findById(id).get();
    }

    @Transactional
    public void updateArticle(Long id,ArticleForm form){
        Article article = articleRepository.findById(id).get();
        Article updateArticle = form.toEntity();
        article.update(updateArticle);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }
}
