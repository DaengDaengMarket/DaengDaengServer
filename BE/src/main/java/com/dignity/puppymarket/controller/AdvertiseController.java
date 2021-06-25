package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.AdvertiseResponseDto;
import com.dignity.puppymarket.service.AdvertiseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
    private final AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

    @GetMapping
    public List<AdvertiseResponseDto> list() {
        return advertiseService.getAdvertises();
    }
}
