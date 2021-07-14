package com.dignity.puppymarket.dto;

import com.dignity.puppymarket.domain.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String email;

    private String password;

    private String nickname;

    private String name;

    private BigCategory concern;

    private String tel;

    private String imagePath;

    private Si si;

    private Gu gu;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .name(name)
                .concern(concern)
                .tel(tel)
                .imagePath(imagePath)
                .si(si)
                .gu(gu)
                .build();
    }
}
