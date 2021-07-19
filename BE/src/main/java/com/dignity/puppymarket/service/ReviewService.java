package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Review;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.Review.ReviewGetResponseDto;
import com.dignity.puppymarket.dto.Review.ReviewRequestDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.error.ReviewNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.ReviewRepository;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         ItemRepository itemRepository,
                         UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public ReviewGetResponseDto getReview(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewGetResponseDto::of)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public ReviewGetResponseDto createReview(Long id, ReviewRequestDto reviewRequestDto,
                                             UserAuthentication userAuthentication) {
        String userEmail = userAuthentication.getEmail();

        Item savedItem = itemRepository.findByItemId(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        User buyer = savedItem.getBuyer();
        if(buyer != null && !buyer.isSame(userEmail)) {
            throw new AccessDeniedException("권한이 없습니다");
        }

        Review review = reviewRequestDto.toEntity();

        Review savedReview = reviewRepository.save(review);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        savedReview.addItem(item);

        return ReviewGetResponseDto.of(savedReview);
    }
}
