package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Setter
public class UserMyPageResponseDto {
    private UserMyPageInfoResponseDto userMyPageInfoResponseDto;

    @Builder
    public UserMyPageResponseDto(UserMyPageInfoResponseDto userMyPageInfoResponseDto) {
        this.userMyPageInfoResponseDto = userMyPageInfoResponseDto;
    }

    public static UserMyPageResponseDto of(User user) {
        if(user == null) return null;

        return UserMyPageResponseDto.builder()
                .userMyPageInfoResponseDto(UserMyPageInfoResponseDto.of(user))
                .build();
    }
}
