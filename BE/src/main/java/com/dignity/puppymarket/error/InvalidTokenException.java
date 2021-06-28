package com.dignity.puppymarket.error;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String token) {
        super("잘못된 토큰입니다 : " + token);
    }
}
