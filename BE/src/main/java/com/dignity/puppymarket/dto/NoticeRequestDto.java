package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Notice;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeRequestDto {

    private String title;
    private String content;

    @Builder
    public NoticeRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString(){
        return "NoticeResponseDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Notice toEntity() {
        return new Notice(null, title, content );
    }
}
