package com.dignity.puppymarket.domain;

public enum ItemStatus {
    NEW("판매중"),
    RESERVED("예약중"),
    HIDE("숨기기"),
    SOLDOUT("거래완료");

    private String title;

    ItemStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
