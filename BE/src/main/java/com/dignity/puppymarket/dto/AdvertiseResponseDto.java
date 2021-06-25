package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Advertise;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AdvertiseResponseDto {
    private Long id;

    private String imagePath;

    private int orders;

    @Builder
    public AdvertiseResponseDto(Long id, String imagePath, int orders) {
        this.id = id;
        this.imagePath = imagePath;
        this.orders = orders;
    }

    public static AdvertiseResponseDto of(Advertise advertise) {
        return AdvertiseResponseDto.builder()
                .id(advertise.getId())
                .imagePath(advertise.getImagePath())
                .orders(advertise.getOrders())
                .build();
    }
}
