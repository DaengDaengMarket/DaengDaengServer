package com.dignity.puppymarket.error;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super("리뷰를 찾을 수 없습니다: id = " + id);
    }
}
