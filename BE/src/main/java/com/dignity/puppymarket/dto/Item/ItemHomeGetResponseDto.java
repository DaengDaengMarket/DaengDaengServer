package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.ItemStatus;
import com.dignity.puppymarket.domain.NegoStatus;
import com.dignity.puppymarket.domain.Pagination;
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

    private int hit;

    private ItemStatus itemStatus;

    private NegoStatus negoStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private ItemImageResponseDto itemImageResponseDto;

    private Si si;

    private Gu gu;

    private Pagination pagination;

    @Builder
    public ItemHomeGetResponseDto(Long id, String name, int price, int hit, ItemStatus itemStatus,
                                  NegoStatus negoStatus, LocalDateTime createdAt, LocalDateTime updatedAt,
                                  ItemImageResponseDto itemImageResponseDto, Si si, Gu gu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.hit = hit;
        this.itemStatus = itemStatus;
        this.negoStatus = negoStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.itemImageResponseDto = itemImageResponseDto;
        this.si = si;
        this.gu = gu;
    }

    public static ItemHomeGetResponseDto of(Item item) {
        if(item == null) return null;

        return ItemHomeGetResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .hit(item.getHit())
                .itemStatus(item.getItemStatus())
                .negoStatus(item.getNegoStatus())
                .createdAt(item.getCreatedAt())
                .updatedAt(item.getUpdatedAt())
                .itemImageResponseDto(
                        item.getItemImageList().stream()
                                .filter(i -> i.getOrders() == 1)
                                .map(ItemImageResponseDto::of)
                                .findAny()
                                .orElse(null)
                )
                .si(item.getSi())
                .gu(item.getGu())
                .build();
    }
}
