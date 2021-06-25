package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.Item.ItemGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemResponseDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
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
    
    public List<ItemHomeGetResponseDto> getHomeItems() {
        return itemRepository.findAll().stream()
                .map(ItemHomeGetResponseDto::of)
                .collect(Collectors.toList());
    }

    public ItemGetResponseDto getItem(Long id) {
        return itemRepository.findById(id)
                .map(ItemGetResponseDto::of)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
