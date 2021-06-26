package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Item.ItemCreateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemCreateResponseDto;
import com.dignity.puppymarket.dto.Item.ItemGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemResponseDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateResponseDto;
import com.dignity.puppymarket.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public List<ItemResponseDto> list() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    public ItemGetResponseDto detail(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public ItemCreateResponseDto create(@RequestBody ItemCreateRequestDto itemCreateRequestDto) {
        return itemService.createItem(itemCreateRequestDto);
    }

    @PutMapping("/{id}")
    public ItemUpdateResponseDto update(@PathVariable Long id,
                                        @RequestBody ItemUpdateRequestDto itemUpdateRequestDto) {
        return itemService.updateItem(id, itemUpdateRequestDto);
    }
}
