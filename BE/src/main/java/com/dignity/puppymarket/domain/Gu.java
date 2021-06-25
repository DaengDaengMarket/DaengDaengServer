package com.dignity.puppymarket.domain;

public enum Gu {
    JONGNOGU("종로구"),
    JUNGGU("중구"),
    YONGSANGU("용산구"),
    SEONGDONGGU("성동구"),
    GWANGJINGU("광진구"),
    DONGDAEMUNGU("동대문구"),
    JUNGNANGGU("중량구"),
    SEONGBUKGU("성북구"),
    GANGBUKGU("강북구"),
    DOBONGGU("도봉구"),
    NOWONGU("노원구"),
    EUNPYEONGGU("은평구"),
    SEODAEMUNGU("서대문구"),
    MAPOGU("마포구"),
    YANGCHEONGU("양천구"),
    GANGSEOGU("강서구"),
    GUROGU("구로구"),
    GEUMCHEONGU("금천구"),
    YEONGDEUNGPOGU("영등포구"),
    DONGJAKGU("동작구"),
    GWANAKGU("관악구"),
    SEOCHOGU("서초구"),
    GANGNAMGU("강남구"),
    SONGPAGU("송파구"),
    GANGDONGGU("강동구");

    private String title;

    Gu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
