package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Notice;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class NoticeResponseDto {


    private String title;
    private String content;

    @Builder
    public NoticeResponseDto(String title, String content) {
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
