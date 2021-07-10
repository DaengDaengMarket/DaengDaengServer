package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.*;
import com.dignity.puppymarket.dto.ItemImageResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ItemCategoryGetResponseDto {

    private Long id;
    private String name;
    private int price;
    private int hit;
    private BigCategory bigCategory;
    private MidCategory midCategory;
    private LocalDateTime createdAt;
    private Si si;
    private Gu gu;
    private List<ItemImageResponseDto> itemImageList;

    public static ItemCategoryGetResponseDto of(Item item) {
        return ItemCategoryGetResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .hit(item.getHit())
                .bigCategory(item.getBigCategory())
                .midCategory(item.getMidCategory())
                .createdAt(item.getCreatedAt())
                .si(item.getSi())
                .gu(item.getGu())
                .itemImageList(
                    item.getItemImageList().stream()
                    .map(itemImage -> ItemImageResponseDto.of(itemImage))
                    .collect(Collectors.toList())
                )
                .build();
    }
}
