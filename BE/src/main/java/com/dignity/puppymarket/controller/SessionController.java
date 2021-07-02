package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.AuthenticationCreateDto;
import com.dignity.puppymarket.dto.SessionResponseDto;
import com.dignity.puppymarket.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")

public class SessionController {
    private final AuthenticationService authenticationService;

    public SessionController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponseDto login(@RequestBody AuthenticationCreateDto authenticationCreateDto) {
        return authenticationService.createToken(authenticationCreateDto);
    }
}
