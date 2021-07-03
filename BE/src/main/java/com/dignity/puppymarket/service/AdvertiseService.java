package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Advertise;
import com.dignity.puppymarket.dto.AdvertiseRequestDto;
import com.dignity.puppymarket.dto.AdvertiseResponseDto;
import com.dignity.puppymarket.dto.AdvertiseUpdateRequestDto;
import com.dignity.puppymarket.error.AdvertiseNotFoundException;
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

    public AdvertiseResponseDto createAdvertise(AdvertiseRequestDto advertiseRequestDto) {
        Advertise advertise = advertiseRequestDto.toEntity();
        advertiseRepository.save(advertise);
        return AdvertiseResponseDto.of(advertise);
    }

    public AdvertiseResponseDto updateAdvertise(Long id, AdvertiseUpdateRequestDto advertiseUpdateRequestDto) {
        Advertise advertise = advertiseRepository.findById(id)
                .orElseThrow(() -> new AdvertiseNotFoundException(id));

        advertise.updateWith(advertiseUpdateRequestDto);

        return AdvertiseResponseDto.of(advertise);
    }

    public AdvertiseResponseDto deleteAdvertise(Long id) {
        Advertise advertise = advertiseRepository.findById(id)
                .orElseThrow(() -> new AdvertiseNotFoundException(id));

        advertiseRepository.delete(advertise);

        return AdvertiseResponseDto.of(advertise);
    }
}
