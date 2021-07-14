package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum NegoStatus implements EnumMapperType {
    OK("가능"),
    NO("불가능");

    private String title;

    NegoStatus(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public static NegoStatus findByNegoStatusCode(String code) {
        return Arrays.stream(NegoStatus.values())
                .filter(nego -> nego.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네고 여부 설정이 잘못되었습니다 : " + code));
    }
}
