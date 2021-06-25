package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemBuyerGetResponseDto {
    private Long id;

    @Builder
    public ItemBuyerGetResponseDto(Long id) {
        this.id = id;
    }

    public static ItemBuyerGetResponseDto of(User user) {
        if(user == null) return null;

        return ItemBuyerGetResponseDto.builder()
                .id(user.getId())
                .build();
    }
}
