package com.dignity.puppymarket.dto.Blame;

import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BlameRequestDto {

    private Long itemId;
    private Long userId;
    private String content;

    public BlameRequestDto(Long itemId, Long userId, String content) {
        this.itemId = itemId;
        this.userId = userId;
        this.content = content;
    }

    @Override
    public String toString(){
        return "BlameRequestDto{" +
                "itemId='" + itemId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Blame toEntity(){
        return Blame.builder()
                .content(content)
                .user(User.builder()
                        .id(userId)
                        .build())
                .item(Item.builder()
                        .id(itemId)
                        .build())
                .build();
    }
}
