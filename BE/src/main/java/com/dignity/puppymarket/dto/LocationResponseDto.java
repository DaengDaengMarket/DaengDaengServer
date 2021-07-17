package com.dignity.puppymarket.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class LocationResponseDto {
    private String si;

    private String gu;

    @Builder
    public LocationResponseDto(String si, String gu) {
        this.si = si;
        this.gu = gu;
    }

    public static LocationResponseDto of(String si, String gu) {
        return LocationResponseDto.builder()
                .si(si)
                .gu(gu)
                .build();
    }
}
