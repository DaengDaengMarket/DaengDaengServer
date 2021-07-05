package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Si;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class LocationResponseDto {
    private Si si;

    private Gu gu;

    @Builder
    public LocationResponseDto(Si si, Gu gu) {
        this.si = si;
        this.gu = gu;
    }

    public static LocationResponseDto of(Si si, Gu gu) {
        return LocationResponseDto.builder()
                .si(si)
                .gu(gu)
                .build();
    }
}
