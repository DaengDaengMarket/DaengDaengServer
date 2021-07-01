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
    private String accessToken;

    @Builder
    public SessionResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public static SessionResponseDto of(String accessToken) {
        return SessionResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
