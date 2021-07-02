package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.AdvertiseResponseDto;
import com.dignity.puppymarket.repository.AdvertiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertiseService {
    private final AdvertiseRepository advertiseRepository;

    public AdvertiseService(AdvertiseRepository advertiseRepository) {
        this.advertiseRepository = advertiseRepository;
    }

    public List<AdvertiseResponseDto> getAdvertises() {
        return advertiseRepository.findAll().stream()
                .map(AdvertiseResponseDto::of)
                .collect(Collectors.toList());
    }
}
