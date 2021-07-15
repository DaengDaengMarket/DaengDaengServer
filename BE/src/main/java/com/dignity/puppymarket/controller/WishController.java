package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.WishResponseDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.WishService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishController {
    private final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PutMapping("item/{id}/wish/{wishStatus}")
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public WishResponseDto updateWishStatus(@PathVariable Long id,
                                            @PathVariable String wishStatus,
                                            UserAuthentication userAuthentication) {
        return wishService.updateWishStatus(id, wishStatus, userAuthentication);
    }
}
