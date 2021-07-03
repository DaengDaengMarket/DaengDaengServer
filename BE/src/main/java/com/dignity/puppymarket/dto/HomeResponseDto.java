package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.dto.Advertise.AdvertiseResponseDto;
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

    private Pagination pagination;

    @Builder
    public HomeResponseDto(List<ItemHomeGetResponseDto> itemList,
                           List<AdvertiseResponseDto> advertiseList,
                           Pagination pagination) {
        this.itemList = itemList;
        this.advertiseList = advertiseList;
        this.pagination = pagination;
    }

    public static HomeResponseDto of(List<ItemHomeGetResponseDto> itemList,
                                     List<AdvertiseResponseDto> advertiseList,
                                     Pagination pagination) {
        return HomeResponseDto.builder()
                .itemList(itemList)
                .advertiseList(advertiseList)
                .pagination(pagination)
                .build();
    }
}
