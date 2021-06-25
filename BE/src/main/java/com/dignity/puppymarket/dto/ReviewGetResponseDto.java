package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ReviewGetResponseDto {
    private Long id;

    private String content;

    private Float rate;

    private LocalDateTime createdAt;

    @Builder
    public ReviewGetResponseDto(Long id, String content, Float rate, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.rate = rate;
        this.createdAt = createdAt;
    }

    public static ReviewGetResponseDto of(Review review) {
        if(review == null) return null;

        return ReviewGetResponseDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
