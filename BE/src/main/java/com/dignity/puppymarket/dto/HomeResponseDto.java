package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HomeResponseDto {
    private List<ItemHomeGetResponseDto> itemList;

    private List<AdvertiseResponseDto> advertiseList;

    @Builder
    public HomeResponseDto(List<ItemHomeGetResponseDto> itemList, List<AdvertiseResponseDto> advertiseList) {
        this.itemList = itemList;
        this.advertiseList = advertiseList;
    }

    public static HomeResponseDto of(List<ItemHomeGetResponseDto> itemList, List<AdvertiseResponseDto> advertiseList) {
        return HomeResponseDto.builder()
                .itemList(itemList)
                .advertiseList(advertiseList)
                .build();
    }
}
