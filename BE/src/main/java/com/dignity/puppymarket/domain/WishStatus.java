package com.dignity.puppymarket.domain;

public enum WishStatus {
    OK("찜함"),
    NO("찜안함");

    private String title;

    WishStatus(String title) {
        this.title = title;
    }
}
