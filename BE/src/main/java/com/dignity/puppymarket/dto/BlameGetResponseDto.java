package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.domain.BlameStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BlameGetResponseDto {
    private Long id;

    private String content;

    private BlameStatus blameStatus;

    private LocalDateTime createdAt;

    @Builder
    public BlameGetResponseDto(Long id, String content, BlameStatus blameStatus, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.blameStatus = blameStatus;
        this.createdAt = createdAt;
    }

    public static BlameGetResponseDto of(Blame blame) {
        if(blame == null) return null;

        return BlameGetResponseDto.builder()
                .id(blame.getId())
                .content(blame.getContent())
                .blameStatus(blame.getBlameStatus())
                .createdAt(blame.getCreatedAt())
                .build();
    }
}
