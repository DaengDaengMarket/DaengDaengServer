package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.AdvertiseRequestDto;
import com.dignity.puppymarket.dto.AdvertiseResponseDto;
import com.dignity.puppymarket.service.AdvertiseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdvertiseResponseDto create(@RequestBody AdvertiseRequestDto advertiseRequestDto) {
        return advertiseService.createAdvertise(advertiseRequestDto);
    }
}
