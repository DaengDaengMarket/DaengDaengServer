package com.dignity.puppymarket.error;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException() {
        super("현재 위치를 찾을 수 없습니다.");
    }
}
