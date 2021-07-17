package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum Si implements EnumMapperType {
    SEOULSI("서울시");

    private String title;

    Si(String title) {
        this.title = title;
    }

    public String getCode() {
        return name();
    }

    public String getTitle() {
        return this.title;
    }

    public static Si findBySiCode(String code) {
        return Arrays.stream(Si.values())
                .filter(si -> si.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("시 설정이 잘못되었습니다 : " + code));
    }
}
