package com.dignity.puppymarket.dto.Review;

import com.dignity.puppymarket.domain.Review;
import com.dignity.puppymarket.dto.Item.ItemMyPageResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ReviewMyPageResponseDto {
    private Long id;

    private String content;

    private Float rate;

    private LocalDateTime createdAt;

    private ItemMyPageResponseDto itemMyPageResponseDto;

    @Builder
    public ReviewMyPageResponseDto(Long id, String content,
                                   Float rate, LocalDateTime createdAt,
                                   ItemMyPageResponseDto itemMyPageResponseDto) {
        this.id = id;
        this.content = content;
        this.rate = rate;
        this.createdAt = createdAt;
        this.itemMyPageResponseDto = itemMyPageResponseDto;
    }

    public static ReviewMyPageResponseDto of(Review review) {
        if(review == null) return null;

        return ReviewMyPageResponseDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .itemMyPageResponseDto(ItemMyPageResponseDto.of(review.getItem()))
                .build();
    }
}
