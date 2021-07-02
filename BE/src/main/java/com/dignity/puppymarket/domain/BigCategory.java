package com.dignity.puppymarket.domain;

public enum BigCategory {
    BIG("대형견"),
    MID("중형견"),
    SMALL("소형견");

    private String title;

    BigCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
