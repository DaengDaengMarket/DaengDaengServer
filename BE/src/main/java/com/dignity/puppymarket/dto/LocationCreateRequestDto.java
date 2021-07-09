package com.dignity.puppymarket.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class LocationCreateRequestDto {
    private String si;

    private String gu;

    @Builder
    public LocationCreateRequestDto(String si, String gu) {
        this.si = si;
        this.gu = gu;
    }
}
