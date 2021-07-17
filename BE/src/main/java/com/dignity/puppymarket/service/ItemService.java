package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.dto.Item.*;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.JpaItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final JpaItemRepository jpaItemRepository;

    public List<ItemResponseDto> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable).stream()
                .map(ItemResponseDto::of)
                .collect(Collectors.toList());
    }
    
    public List<ItemHomeGetResponseDto> getHomeItems(Pageable pageable) {
        return itemRepository.findAll(pageable).stream()
                .map(ItemHomeGetResponseDto::of)
                .collect(Collectors.toList());
    }

    public Pagination getHomeItemsPagination(Pageable pageable) {
        return Pagination.itemWith(itemRepository.findAll(pageable));
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

    public List<ItemCategoryGetResponseDto> getCategoryItem(Long id, String name) {
        return  jpaItemRepository.getItemsInCategory(id, name).stream()
                .map(item -> ItemCategoryGetResponseDto.of(item))
                .collect(Collectors.toList());
    }

    public List<ItemCategoryGetResponseDto> search(ItemSearchCondition condition) {
        return jpaItemRepository.search(condition);
    }
}
