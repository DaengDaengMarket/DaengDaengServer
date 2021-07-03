package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Review.ReviewGetResponseDto;
import com.dignity.puppymarket.dto.Review.ReviewRequestDto;
import com.dignity.puppymarket.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ReviewGetResponseDto detail(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @PostMapping("/items/{id}/review")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewGetResponseDto create(@PathVariable Long id,
                                       @RequestBody ReviewRequestDto reviewRequestDto) {
        return reviewService.createReview(id, reviewRequestDto);
    }
}
