package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.domain.ChatRoom;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.ItemImage;
import com.dignity.puppymarket.domain.ItemStatus;
import com.dignity.puppymarket.domain.MidCategory;
import com.dignity.puppymarket.domain.NegoStatus;
import com.dignity.puppymarket.domain.Review;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.domain.Wish;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private Long id;

    private String name;

    private int price;

    private String description;

    private int hit;

    private ItemStatus itemStatus;

    private NegoStatus negoStatus;

    private BigCategory bigCategory;

    private MidCategory midCategory;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Si si;

    private Gu gu;

    private User seller;

    private User buyer;

    List<ItemImage> itemImageList;

    private Blame blame;

    private Wish wish;

    private Review review;

    private ChatRoom chatRoom;

    public static ItemResponseDto of(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .hit(item.getHit())
                .itemStatus(item.getItemStatus())
                .negoStatus(item.getNegoStatus())
                .bigCategory(item.getBigCategory())
                .midCategory(item.getMidCategory())
                .createdAt(item.getCreatedAt())
                .updatedAt(item.getUpdatedAt())
                .si(item.getSi())
                .gu(item.getGu())
                .seller(item.getSeller())
                .buyer(item.getBuyer())
                .itemImageList(item.getItemImageList())
                .blame(item.getBlame())
                .wish(item.getWish())
                .review(item.getReview())
                .chatRoom(item.getChatRoom())
                .build();
    }
}
