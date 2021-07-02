package com.dignity.puppymarket.domain;

public enum MidCategory {
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

    public String getTitle() {
        return title;
    }
}
