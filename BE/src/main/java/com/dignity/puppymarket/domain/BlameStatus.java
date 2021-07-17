package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum BlameStatus implements EnumMapperType {
    OK("신고함"),
    NO("신고안함");

    private String title;

    BlameStatus(String title) {
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

    public static BlameStatus findByBlameStatusCode(String code) {
        return Arrays.stream(BlameStatus.values())
                .filter(blame -> blame.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("신고 여부 설정이 잘못되었습니다 : " + code));
    }
}
