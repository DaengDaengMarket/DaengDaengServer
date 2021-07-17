package com.dignity.puppymarket.dto.Review;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ReviewRequestDto {
    private String content;

    private String rate;

    private Item item;

    @Builder
    public ReviewRequestDto(String content, String rate, Item item) {
        this.content = content;
        this.rate = rate;
        this.item = item;
    }

    public Review toEntity() {
        return Review.builder()
                .content(this.content)
                .rate(Float.parseFloat(this.rate))
                .build();
    }
}
