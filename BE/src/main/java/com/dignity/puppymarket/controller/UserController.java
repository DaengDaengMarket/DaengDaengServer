package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.User.UserRequestDto;
import com.dignity.puppymarket.dto.User.UserResponseDto;
import com.dignity.puppymarket.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto detail(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public String addMember(@RequestBody UserRequestDto userDto) {
        return userService.join(userDto);
    }
}
