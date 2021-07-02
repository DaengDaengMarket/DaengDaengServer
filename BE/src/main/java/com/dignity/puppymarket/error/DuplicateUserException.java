package com.dignity.puppymarket.error;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String email) {
        super(email + "은 이미 사용중인 이메일입니다.");
    }
}
