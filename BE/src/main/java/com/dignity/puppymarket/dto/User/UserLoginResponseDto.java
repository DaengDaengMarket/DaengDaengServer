package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserLoginResponseDto {
    private Long id;

    private String email;

    private String password;

    @Builder
    public UserLoginResponseDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static UserLoginResponseDto of(User user) {
        return UserLoginResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
