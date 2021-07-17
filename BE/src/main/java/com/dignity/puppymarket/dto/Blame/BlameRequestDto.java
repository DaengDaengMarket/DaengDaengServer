package com.dignity.puppymarket.dto.Blame;

import com.dignity.puppymarket.domain.Blame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlameRequestDto {
    private String content;

    public BlameRequestDto(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "BlameRequestDto{" +
                ", content='" + content + '\'' +
                '}';
    }

    public Blame toEntity(){
        return Blame.builder()
                .content(content)
                .build();
    }
}
