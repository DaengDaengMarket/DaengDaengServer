package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.domain.Review;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.dto.MyPage.MyPageGetResponseDto;
import com.dignity.puppymarket.dto.ReviewMyPageResponseDto;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.ReviewRepository;
import com.dignity.puppymarket.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyPageService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ReviewRepository reviewRepository;

    public MyPageService(UserRepository userRepository,
                         ItemRepository itemRepository,
                         ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.reviewRepository = reviewRepository;
    }

    public MyPageGetResponseDto getMyPageInfo(Long id, String menu, Pageable pageable) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        MyPageGetResponseDto myPageGetResponseDto = MyPageGetResponseDto.of(user);

        if(menu.equals("sells")) {
            Page<Item> sellPageItems = itemRepository.findAllBySellerId(id, pageable);
            List<ItemHomeGetResponseDto> sellItems = sellPageItems.stream()
                    .map(ItemHomeGetResponseDto::of)
                    .collect(Collectors.toList());
            myPageGetResponseDto.setSellerItemList(sellItems);

            Pagination pagination = Pagination.itemWith(sellPageItems);
            myPageGetResponseDto.setPagination(pagination);
            return myPageGetResponseDto;
        }

        if(menu.equals("buys")) {
            Page<Item> buyPageItems = itemRepository.findAllBySellerId(id, pageable);
            List<ItemHomeGetResponseDto> sellItems = buyPageItems.stream()
                    .map(ItemHomeGetResponseDto::of)
                    .collect(Collectors.toList());
            myPageGetResponseDto.setBuyerItemList(sellItems);

            Pagination pagination = Pagination.itemWith(buyPageItems);
            myPageGetResponseDto.setPagination(pagination);
            return myPageGetResponseDto;
        }

        if(menu.equals("reviews")) {
            Page<Review> pageReviews = reviewRepository.findAllReviews(id, pageable);
            List<ReviewMyPageResponseDto> reviews = pageReviews.stream()
                    .map(ReviewMyPageResponseDto::of)
                    .collect(Collectors.toList());
            myPageGetResponseDto.setReviewMyPageResponseDtoList(reviews);

            Pagination pagination = Pagination.reviewWith(pageReviews);
            myPageGetResponseDto.setPagination(pagination);
            return myPageGetResponseDto;
        }
        return myPageGetResponseDto;
    }
}
