package com.dignity.puppymarket.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class LocationRequestDto {
    private Long latitude;

    private Long longitude;

    @Builder
    public LocationRequestDto(Long latitude, Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
