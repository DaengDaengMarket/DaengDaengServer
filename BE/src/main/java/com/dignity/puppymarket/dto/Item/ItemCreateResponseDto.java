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
public class ItemCreateResponseDto {
    private Long id;

    private String name;

    @Builder
    public ItemCreateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ItemCreateResponseDto of(Item item) {
        return ItemCreateResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }
}
