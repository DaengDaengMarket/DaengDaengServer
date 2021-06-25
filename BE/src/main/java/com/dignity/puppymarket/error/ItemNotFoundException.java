package com.dignity.puppymarket.error;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("상품을 찾을 수 없습니다: " + id);
    }
}
