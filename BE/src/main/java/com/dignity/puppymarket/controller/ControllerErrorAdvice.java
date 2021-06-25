package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.ErrorResponse;
import com.dignity.puppymarket.error.DuplicateUserException;
import com.dignity.puppymarket.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerErrorAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFound(UserNotFoundException ex) {
        return ErrorResponse.of(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(DuplicateUserException.class)
    public ErrorResponse handleDuplicateUser(DuplicateUserException exception) {
        return ErrorResponse.of(exception.getMessage());
    }
}
