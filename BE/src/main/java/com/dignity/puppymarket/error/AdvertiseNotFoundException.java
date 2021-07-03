package com.dignity.puppymarket.error;

public class AdvertiseNotFoundException extends RuntimeException {
    public AdvertiseNotFoundException(Long id) {
        super("광고를 찾을 수 없습니다 : id = " + id);
    }
}
