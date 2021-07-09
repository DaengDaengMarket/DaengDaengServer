package com.dignity.puppymarket.domain;

import java.util.Arrays;

public enum ItemStatus implements EnumMapperType {
    NEW("판매중"),
    RESERVED("예약중"),
    HIDE("숨기기"),
    SOLDOUT("거래완료");

    private String title;

    ItemStatus(String title) {
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

    public static ItemStatus findByItemStatusCode(String code) {
        return Arrays.stream(ItemStatus.values())
                .filter(itemStatus -> itemStatus.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("아이템 상태 설정이 잘못되었습니다 : " + code));
    }
}
