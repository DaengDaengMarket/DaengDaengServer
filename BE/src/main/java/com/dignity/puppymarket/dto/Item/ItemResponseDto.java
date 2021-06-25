package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.ItemStatus;
import com.dignity.puppymarket.domain.MidCategory;
import com.dignity.puppymarket.domain.NegoStatus;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.BlameGetResponseDto;
import com.dignity.puppymarket.dto.ChatRoomGetResponseDto;
import com.dignity.puppymarket.dto.ItemImageResponseDto;
import com.dignity.puppymarket.dto.ReviewGetResponseDto;
import com.dignity.puppymarket.dto.WishGetResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<ItemImageResponseDto> itemImageList;

    private List<BlameGetResponseDto> blameList;

    private List<WishGetResponseDto> wishList;

    private ReviewGetResponseDto reviewGetResponseDto;

    private List<ChatRoomGetResponseDto> chatRoomList;

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
                .itemImageList(
                        item.getItemImageList().stream()
                            .map(ItemImageResponseDto::of)
                            .collect(Collectors.toList())
                )
                .blameList(
                        item.getBlameList().stream()
                            .map(BlameGetResponseDto::of)
                            .collect(Collectors.toList())
                )
                .wishList(
                        item.getWishList().stream()
                            .map(WishGetResponseDto::of)
                            .collect(Collectors.toList())
                )
                .reviewGetResponseDto(ReviewGetResponseDto.of(item.getReview()))
                .chatRoomList(
                        item.getChatRoomList().stream()
                                .map(ChatRoomGetResponseDto::of)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
