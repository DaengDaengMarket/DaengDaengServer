package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Wish;
import com.dignity.puppymarket.domain.WishStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WishResponseDto {
    private Long id;

    private WishStatus wishStatus;

    @Builder
    public WishResponseDto(Long id, WishStatus wishStatus) {
        this.id = id;
        this.wishStatus = wishStatus;
    }

    public static WishResponseDto of(Wish wish) {
        return WishResponseDto.builder()
                .id(wish.getId())
                .wishStatus(wish.getWishStatus())
                .build();
    }
}
