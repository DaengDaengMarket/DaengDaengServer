package com.dignity.puppymarket.dto.Advertise;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AdvertiseUpdateRequestDto {
    private String imagePath;

    private int orders;

    @Builder
    public AdvertiseUpdateRequestDto(String imagePath, int orders) {
        this.imagePath = imagePath;
        this.orders = orders;
    }
}


