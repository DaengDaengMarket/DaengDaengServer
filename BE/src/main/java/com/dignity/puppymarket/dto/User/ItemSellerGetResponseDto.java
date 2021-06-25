package com.dignity.puppymarket.dto.User;

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
public class ItemSellerGetResponseDto {
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private String imagePath;

    private String tel;

    private Float rate;

    private Si si;

    private Gu gu;

    @Builder
    public ItemSellerGetResponseDto(Long id, String email, String password, String nickname,
                                    String imagePath, String tel, Float rate, Si si, Gu gu) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.imagePath = imagePath;
        this.tel = tel;
        this.rate = rate;
        this.si = si;
        this.gu = gu;
    }

    public static ItemSellerGetResponseDto of(User user) {
        if(user == null) return null;

        return ItemSellerGetResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .imagePath(user.getImagePath())
                .tel(user.getTel())
                .rate(user.getRate())
                .si(user.getSi())
                .gu(user.getGu())
                .build();
    }
}
