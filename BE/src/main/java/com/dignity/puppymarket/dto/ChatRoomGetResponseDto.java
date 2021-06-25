package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.ChatRoom;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ChatRoomGetResponseDto {
    private Long id;

    private String path;

    @Builder
    public ChatRoomGetResponseDto(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public static ChatRoomGetResponseDto of(ChatRoom chatRoom) {
        if(chatRoom == null) return null;

        return ChatRoomGetResponseDto.builder()
                .id(chatRoom.getId())
                .path(chatRoom.getPath())
                .build();
    }
}
