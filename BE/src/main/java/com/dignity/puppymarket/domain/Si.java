package com.dignity.puppymarket.domain;

import java.util.Arrays;
import java.util.List;

public enum Si {
    SEOULSI("서울시", Arrays.asList(Gu.JONGNOGU, Gu.JUNGGU, Gu.YONGSANGU, Gu.SEONGDONGGU, Gu.GWANGJINGU,
            Gu.DONGDAEMUNGU, Gu.JUNGNANGGU, Gu.SEONGBUKGU, Gu.GANGBUKGU, Gu.DOBONGGU, Gu.NOWONGU, Gu.EUNPYEONGGU,
            Gu.SEODAEMUNGU, Gu.MAPOGU, Gu.YANGCHEONGU, Gu.GANGSEOGU, Gu.GUROGU, Gu.GEUMCHEONGU, Gu.YEONGDEUNGPOGU,
            Gu.DONGJAKGU, Gu.GWANAKGU, Gu.SEOCHOGU, Gu.GANGNAMGU, Gu.SONGPAGU, Gu.GANGDONGGU));

    private String title;
    private List<Gu> guList;

    Si(String title, List<Gu> guList) {
        this.title = title;
        this.guList = guList;
    }

    public String getTitle() {
        return title;
    }
}
