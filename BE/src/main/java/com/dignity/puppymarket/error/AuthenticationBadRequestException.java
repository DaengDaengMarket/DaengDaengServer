package com.dignity.puppymarket.error;

public class AuthenticationBadRequestException extends RuntimeException {
    public AuthenticationBadRequestException(String email) {
        super("인증에 실패하였습니다 " + email);
    }
}
