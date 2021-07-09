package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.LocationCreateRequestDto;
import com.dignity.puppymarket.dto.LocationRequestDto;
import com.dignity.puppymarket.dto.LocationResponseDto;
import com.dignity.puppymarket.service.LocationService;
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

    @PostMapping("/mypage/location")
    public LocationResponseDto findLocation(@RequestBody LocationRequestDto locationRequestDto) throws Exception {
        return locationService.findLocation(locationRequestDto);
    }

    @PostMapping("/mypage/{id}/location")
    public LocationResponseDto saveLocation(@PathVariable Long id,
                                            @RequestBody LocationCreateRequestDto locationCreateRequestDto) {
        return locationService.saveLocation(id, locationCreateRequestDto);
    }
}
