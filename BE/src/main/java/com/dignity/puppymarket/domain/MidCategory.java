package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum MidCategory implements EnumMapperType {
    FEED("사료"),
    HYGIENE("위생"),
    BEAUTY("미용"),
    HOUSE("하우스"),
    TOY("장난감"),
    DRINKER("급수기"),
    CLOTH("의류"),
    OUTER("외출용품"),
    ETC("기타");

    private String title;

    MidCategory(String title) {
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

    public static MidCategory findByMidCategoryCode(String code) {
        return Arrays.stream(MidCategory.values())
                .filter(mid -> mid.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("중분류 카테고리 설정이 잘못되었습니다 : " + code));
    }
}
