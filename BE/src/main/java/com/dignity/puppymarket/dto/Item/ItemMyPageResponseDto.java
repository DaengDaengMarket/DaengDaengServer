package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.Item;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class ItemMyPageResponseDto {
    private Long id;

    private String name;

    @Builder
    public ItemMyPageResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ItemMyPageResponseDto of(Item item) {
        if(item == null) return null;

        return ItemMyPageResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }
}
