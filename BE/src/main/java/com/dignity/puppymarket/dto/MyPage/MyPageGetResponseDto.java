package com.dignity.puppymarket.dto.MyPage;

import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.dto.Review.ReviewMyPageResponseDto;
import com.dignity.puppymarket.dto.User.UserMyPageResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MyPageGetResponseDto {
    private UserMyPageResponseDto userMyPageResponseDto;

    private List<ItemHomeGetResponseDto> sellerItemList;

    private List<ItemHomeGetResponseDto> buyerItemList;

    private List<ReviewMyPageResponseDto> reviewMyPageResponseDtoList;

    private Pagination pagination;

    @Builder
    public MyPageGetResponseDto(UserMyPageResponseDto userMyPageResponseDto,
                                List<ItemHomeGetResponseDto> sellerItemList,
                                List<ItemHomeGetResponseDto> buyerItemList,
                                List<ReviewMyPageResponseDto> reviewMyPageResponseDtoList,
                                Pagination pagination) {
        this.userMyPageResponseDto = userMyPageResponseDto;
        this.sellerItemList = sellerItemList;
        this.buyerItemList = buyerItemList;
        this.reviewMyPageResponseDtoList = reviewMyPageResponseDtoList;
        this.pagination = pagination;
    }

    public static MyPageGetResponseDto of(User user) {
        if(user == null) return null;

        return MyPageGetResponseDto.builder()
                .userMyPageResponseDto(UserMyPageResponseDto.of(user))
                .build();
    }
}
