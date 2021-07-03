package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.Review.ReviewGetResponseDto;
import com.dignity.puppymarket.error.ReviewNotFoundException;
import com.dignity.puppymarket.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewGetResponseDto getReview(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewGetResponseDto::of)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }
}
