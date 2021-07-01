package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.dto.ReviewMyPageResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserMyPageResponseDto {
    private Long id;

    private String email;

    private String nickname;

    private String imagePath;

    private String tel;

    private Float rate;

    private Si si;

    private Gu gu;

    private BigCategory concern;

    private List<ItemHomeGetResponseDto> sellerItemList;

    private List<ItemHomeGetResponseDto> buyerItemList;

    private List<ReviewMyPageResponseDto> reviewMyPageResponseDtoList;

    @Builder
    public UserMyPageResponseDto(Long id, String email, String nickname, String imagePath,
                                 String tel, Float rate, Si si, Gu gu, BigCategory concern,
                                 List<ItemHomeGetResponseDto> sellerItemList,
                                 List<ItemHomeGetResponseDto> buyerItemList,
                                 List<ReviewMyPageResponseDto> reviewMyPageResponseDtoList) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.imagePath = imagePath;
        this.tel = tel;
        this.rate = rate;
        this.si = si;
        this.gu = gu;
        this.concern = concern;
        this.sellerItemList = sellerItemList;
        this.buyerItemList = buyerItemList;
        this.reviewMyPageResponseDtoList = reviewMyPageResponseDtoList;
    }

    public static UserMyPageResponseDto of(User user) {
        if(user == null) return null;

        return UserMyPageResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .imagePath(user.getImagePath())
                .tel(user.getTel())
                .rate(user.getRate())
                .si(user.getSi())
                .gu(user.getGu())
                .concern(user.getConcern())
                .sellerItemList(
                        user.getSellerItemList().stream()
                            .map(ItemHomeGetResponseDto::of)
                            .collect(Collectors.toList())
                )
                .buyerItemList(
                        user.getBuyerItemList().stream()
                                .map(ItemHomeGetResponseDto::of)
                                .collect(Collectors.toList())
                )
                .reviewMyPageResponseDtoList(
                        user.getSellerItemList().stream()
                            .map(item -> ReviewMyPageResponseDto.of(item.getReview()))
                            .collect(Collectors.toList())
                )
                .build();
    }
}
