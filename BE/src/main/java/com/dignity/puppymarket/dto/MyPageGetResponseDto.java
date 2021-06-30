package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.User.UserMyPageResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MyPageGetResponseDto {
    private UserMyPageResponseDto userMyPageResponseDto;

    @Builder
    public MyPageGetResponseDto(UserMyPageResponseDto userMyPageResponseDto) {
        this.userMyPageResponseDto = userMyPageResponseDto;
    }

    public static MyPageGetResponseDto of(User user) {
        if(user == null) return null;

        return MyPageGetResponseDto.builder()
                .userMyPageResponseDto(UserMyPageResponseDto.of(user))
                .build();
    }
}
