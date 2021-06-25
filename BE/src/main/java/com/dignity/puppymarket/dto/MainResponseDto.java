package com.dignity.puppymarket.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MainResponseDto {
    private List<AdvertiseResponseDto> advertiseList;
}
