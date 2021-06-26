package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.dto.Item.ItemCreateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemCreateResponseDto;
import com.dignity.puppymarket.dto.Item.ItemDeleteResponseDto;
import com.dignity.puppymarket.dto.Item.ItemGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemResponseDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateResponseDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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

    public ItemCreateResponseDto createItem(ItemCreateRequestDto itemCreateRequestDto) {
        Item item = itemCreateRequestDto.toEntity();
        Item savedItem = itemRepository.save(item);
        return ItemCreateResponseDto.of(savedItem);
    }

    public ItemUpdateResponseDto updateItem(Long id, ItemUpdateRequestDto itemUpdateRequestDto) {
        Item item = findItem(id);

        item.updateWith(itemUpdateRequestDto);

        return ItemUpdateResponseDto.of(item);
    }

    public ItemDeleteResponseDto deleteItem(Long id) {
        Item item = findItem(id);

        itemRepository.delete(item);

        return ItemDeleteResponseDto.of(item);
    }

    public Item findItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
