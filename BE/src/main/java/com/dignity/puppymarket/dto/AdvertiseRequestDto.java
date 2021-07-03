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
public class AdvertiseRequestDto {
    private String imagePath;

    @Builder
    public AdvertiseRequestDto(String imagePath) {
        this.imagePath = imagePath;
    }

    public Advertise toEntity() {
        return Advertise.builder()
                .imagePath(this.imagePath)
                .build();
    }
}
