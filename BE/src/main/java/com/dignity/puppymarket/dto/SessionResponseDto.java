package com.dignity.puppymarket.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SessionResponseDto {
    private String token;

    @Builder
    public SessionResponseDto(String token) {
        this.token = token;
    }

    public static SessionResponseDto of(String token) {
        return SessionResponseDto.builder()
                .token(token)
                .build();
    }
}
