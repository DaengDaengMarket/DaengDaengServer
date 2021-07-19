package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.LocationCreateRequestDto;
import com.dignity.puppymarket.dto.LocationRequestDto;
import com.dignity.puppymarket.dto.LocationResponseDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.LocationService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/mypage/location")
    public LocationResponseDto findLocation(LocationRequestDto locationRequestDto) {
        return locationService.findLocation(locationRequestDto);
    }

    @PostMapping("/mypage/{id}/location")
    //@PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public LocationResponseDto saveLocation(@PathVariable Long id,
                                            @RequestBody LocationCreateRequestDto locationCreateRequestDto,
                                            UserAuthentication userAuthentication) {
        if (userAuthentication == null) {
            throw new AccessDeniedException("권한이 없습니다");
        }
        return locationService.saveLocation(id, locationCreateRequestDto, userAuthentication);
    }
}
