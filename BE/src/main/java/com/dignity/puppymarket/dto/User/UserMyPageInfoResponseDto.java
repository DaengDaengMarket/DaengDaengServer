package com.dignity.puppymarket.dto.User;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Si;
import com.dignity.puppymarket.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserMyPageInfoResponseDto {
    private Long id;

    private String email;

    private String nickname;

    private String name;

    private String imagePath;

    private String tel;

    private Float rate;

    private Si si;

    private Gu gu;

    private BigCategory concern;

    @Builder
    public UserMyPageInfoResponseDto(Long id, String email, String nickname, String name,
                                     String imagePath, String tel, Float rate, Si si, Gu gu, BigCategory concern) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.imagePath = imagePath;
        this.tel = tel;
        this.rate = rate;
        this.si = si;
        this.gu = gu;
        this.concern = concern;
    }

    public static UserMyPageInfoResponseDto of(User user) {
        return UserMyPageInfoResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .name(user.getName())
                .imagePath(user.getImagePath())
                .tel(user.getTel())
                .rate(user.getRate())
                .si(user.getSi())
                .gu(user.getGu())
                .concern(user.getConcern())
                .build();
    }
}
