package com.example.hongpack.Repository;

import com.example.hongpack.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article , Long> {
    List<Article> findAll();

    Optional<Article> findById(Long id);

    void deleteById(Long id);
}
