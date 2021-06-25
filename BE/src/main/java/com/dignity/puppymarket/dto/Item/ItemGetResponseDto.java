package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.MidCategory;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.dto.BlameGetResponseDto;
import com.dignity.puppymarket.dto.ChatRoomGetResponseDto;
import com.dignity.puppymarket.dto.ItemImageResponseDto;
import com.dignity.puppymarket.dto.ReviewGetResponseDto;
import com.dignity.puppymarket.dto.User.ItemBuyerGetResponseDto;
import com.dignity.puppymarket.dto.User.ItemSellerGetResponseDto;
import com.dignity.puppymarket.dto.WishGetResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@AllArgsConstructor
@Builder
public class ItemGetResponseDto {
    private Long id;

    private String name;

    private int price;

    private String description;

    private int hit;

    private BigCategory bigCategory;

    private MidCategory midCategory;

    private LocalDateTime createdAt;

    private Si si;

    private Gu gu;

    private ItemSellerGetResponseDto seller;

    private ItemBuyerGetResponseDto buyer;

    private List<ItemImageResponseDto> itemImageList;

    private List<BlameGetResponseDto> blameList;

    private List<WishGetResponseDto> wishList;

    private ReviewGetResponseDto reviewGetResponseDto;

    private List<ChatRoomGetResponseDto> chatRoomList;

    public static ItemGetResponseDto of(Item item) {
        return ItemGetResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .description(item.getDescription())
                .hit(item.getHit())
                .bigCategory(item.getBigCategory())
                .midCategory(item.getMidCategory())
                .createdAt(item.getCreatedAt())
                .si(item.getSi())
                .gu(item.getGu())
                .seller(ItemSellerGetResponseDto.of(item.getSeller()))
                .buyer(ItemBuyerGetResponseDto.of(item.getBuyer()))
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
