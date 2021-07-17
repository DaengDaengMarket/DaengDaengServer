package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum WishStatus implements EnumMapperType {
    OK("찜함"),
    NO("찜안함");

    private String title;

    WishStatus(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public static WishStatus findByWishStatusCode(String code) {
        return Arrays.stream(WishStatus.values())
                .filter(wish -> wish.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("찜 여부 설정이 잘못되었습니다 : " + code));
    }
}
