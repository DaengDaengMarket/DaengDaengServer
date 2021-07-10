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
public class ItemUpdateResponseDto {
    private Long id;

    private String name;

    @Builder
    public ItemUpdateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ItemUpdateResponseDto of(Item item) {
        return ItemUpdateResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }
}
