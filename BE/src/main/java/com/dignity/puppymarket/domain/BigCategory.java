package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum BigCategory implements EnumMapperType {
    BIG("대형견"),
    MID("중형견"),
    SMALL("소형견");

    private String title;

    BigCategory(String title) {
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

    public static BigCategory findByBigCategoryCode(String code) {
        return Arrays.stream(BigCategory.values())
                .filter(big -> big.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("대분류 카테고리 설정이 잘못되었습니다 : " + code));
    }
}
