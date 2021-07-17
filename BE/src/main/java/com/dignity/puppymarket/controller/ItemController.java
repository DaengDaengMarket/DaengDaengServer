package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Item.*;
import com.dignity.puppymarket.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public List<ItemResponseDto> list(
            @PageableDefault(direction = Sort.Direction.DESC, size = 12, sort = "id") Pageable pageable) {
        return itemService.getItems(pageable);
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

    @DeleteMapping("/{id}")
    public ItemDeleteResponseDto delete(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/categories/{id}/{name}")
    public List<ItemCategoryGetResponseDto> getItemInCategory(@PathVariable Long id,
                                                        @PathVariable String name) {
        return itemService.getCategoryItem(id, name);
    }

    // QueryString으로 ex) /search?name=tony&midCategory=FEED&bigCategory=BIG
    @GetMapping("/search")
    public List<ItemCategoryGetResponseDto> searchItems(@ModelAttribute ItemSearchCondition condition) {
        return itemService.search(condition);
    }
}
