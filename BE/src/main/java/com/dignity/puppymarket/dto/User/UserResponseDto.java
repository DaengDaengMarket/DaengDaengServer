package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.domain.ChatMessage;
import com.dignity.puppymarket.domain.ChatRoom;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.domain.Wish;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private String imagePath;

    private String tel;

    private Float rate;

    private Si si;

    private Gu gu;

    private BigCategory concern;

    private List<Item> sellerItemList;

    private List<Item> buyerItemList;

    private List<Blame> blameList;

    private List<Wish> wishList;

    private List<ChatRoom> chatRoomList;

    private List<ChatMessage> chatMessageList;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .imagePath(user.getImagePath())
                .tel(user.getTel())
                .rate(user.getRate())
                .si(user.getSi())
                .gu(user.getGu())
                .concern(user.getConcern())
                .sellerItemList((user.getSellerItemList()))
                .buyerItemList(user.getBuyerItemList())
                .blameList(user.getBlameList())
                .wishList(user.getWishList())
                .chatRoomList(user.getChatRoomList())
                .chatMessageList(user.getChatMessageList())
                .build();
    }
}
