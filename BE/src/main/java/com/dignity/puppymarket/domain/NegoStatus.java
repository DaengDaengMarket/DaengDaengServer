package com.dignity.puppymarket.domain;

public enum NegoStatus {
    OK("가능"),
    NO("불가능");

    private String title;

    NegoStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
