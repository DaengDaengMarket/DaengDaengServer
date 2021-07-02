package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.ItemImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemImageResponseDto {
    private Long id;

    private String path;

    private int orders;

    @Builder
    public ItemImageResponseDto(Long id, String path, int orders) {
        this.id = id;
        this.path = path;
        this.orders = orders;
    }

    public static ItemImageResponseDto of(ItemImage itemImage) {
        if(itemImage == null) return null;

        return ItemImageResponseDto.builder()
                .id(itemImage.getId())
                .path(itemImage.getPath())
                .orders(itemImage.getOrders())
                .build();
    }
}
