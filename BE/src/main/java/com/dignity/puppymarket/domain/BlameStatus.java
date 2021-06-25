package com.dignity.puppymarket.domain;

public enum BlameStatus {
    OK("신고함"),
    NO("신고안함");

    private String title;

    BlameStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
