package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Review.ReviewGetResponseDto;
import com.dignity.puppymarket.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
