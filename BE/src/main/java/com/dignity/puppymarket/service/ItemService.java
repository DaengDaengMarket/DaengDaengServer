package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.ItemResponseDto;
import com.dignity.puppymarket.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream()
                .map(ItemResponseDto::of)
                .collect(Collectors.toList());
    }
}
