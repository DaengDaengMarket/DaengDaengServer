package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.dto.ItemImageResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemHomeGetResponseDto {
    private Long id;

    private String name;

    private int price;

    private LocalDateTime createdAt;

    private ItemImageResponseDto itemImageResponseDto;

    private Si si;

    private Gu gu;

    @Builder
    public ItemHomeGetResponseDto(Long id, String name, int price, LocalDateTime createdAt,
                                  ItemImageResponseDto itemImageResponseDto, Si si, Gu gu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
        this.itemImageResponseDto = itemImageResponseDto;
        this.si = si;
        this.gu = gu;
    }

    public static ItemHomeGetResponseDto of(Item item) {
        return ItemHomeGetResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .createdAt(item.getCreatedAt())
                .itemImageResponseDto(
                        item.getItemImageList().stream()
                            .filter(itemImage -> itemImage.getOrders() == 1)
                            .map(ItemImageResponseDto::of)
                            .findFirst()
                            .get()
                )
                .si(item.getSi())
                .gu(item.getGu())
                .build();
    }
}
