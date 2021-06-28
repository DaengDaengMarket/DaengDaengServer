package com.example.hongpack.controller;

import com.example.hongpack.Repository.ArticleRepository;
import com.example.hongpack.dto.ArticleForm;
import com.example.hongpack.entity.Article;
//import com.example.hongpack.service.NoticeService;
import com.example.hongpack.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired //스프링부트가 알아서 객채 생성및 연결
    private ArticleService articleService;

    @GetMapping("/article")
    public String viewArticle(Model model){
        List<Article> articles = articleService.viewArticle();
        model.addAttribute("article", articles);
        return "articles/article";
    }


    //화면 보여주기
    @GetMapping("/articles/new")
    public String newArticle(){

        return "articles/new";
    }

    //던진거 받기
    @PostMapping("/article")
    public String createArticle(ArticleForm form) {

        Article saved = articleService.saveArticle(form);
        return "redirect:/article";
    }


    //게시글 상세보기
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);

        return "articles/updateForm";
    }

    @PutMapping("/article/{id}")
    public void updateArticle(@PathVariable Long id, ArticleForm form){
        articleService.updateArticle(id, form);
    }

    //delete
    @DeleteMapping("/articles/{id}")
    public String deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return "articles/article";
    }


}
