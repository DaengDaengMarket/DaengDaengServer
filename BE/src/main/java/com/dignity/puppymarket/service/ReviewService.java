package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Review;
import com.dignity.puppymarket.dto.Review.ReviewGetResponseDto;
import com.dignity.puppymarket.dto.Review.ReviewRequestDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.error.ReviewNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         ItemRepository itemRepository) {
        this.reviewRepository = reviewRepository;
        this.itemRepository = itemRepository;
    }

    public ReviewGetResponseDto getReview(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewGetResponseDto::of)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public ReviewGetResponseDto createReview(Long id, ReviewRequestDto reviewRequestDto) {
        Review review = reviewRequestDto.toEntity();

        Review savedReview = reviewRepository.save(review);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        savedReview.addItem(item);

        return ReviewGetResponseDto.of(savedReview);
    }
}
