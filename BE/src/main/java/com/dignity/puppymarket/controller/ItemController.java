package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Item.ItemCreateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemCreateResponseDto;
import com.dignity.puppymarket.dto.Item.ItemDeleteResponseDto;
import com.dignity.puppymarket.dto.Item.ItemGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemResponseDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateRequestDto;
import com.dignity.puppymarket.dto.Item.ItemUpdateResponseDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public List<ItemResponseDto> list(
            @PageableDefault(direction = Sort.Direction.DESC, size = 12, sort = "id") Pageable pageable) {
        return itemService.getItems(pageable);
    }

    @GetMapping("/{id}")
    public ItemGetResponseDto detail(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public ItemCreateResponseDto create(@RequestBody ItemCreateRequestDto itemCreateRequestDto,
                                        UserAuthentication userAuthentication) {
        return itemService.createItem(itemCreateRequestDto, userAuthentication);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public ItemUpdateResponseDto update(@PathVariable Long id,
                                        @RequestBody ItemUpdateRequestDto itemUpdateRequestDto,
                                        UserAuthentication userAuthentication) {
        return itemService.updateItem(id, itemUpdateRequestDto, userAuthentication);
    }

    @PutMapping("/{id}/{itemStatus}")
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public ItemUpdateResponseDto updateItemStatus(@PathVariable Long id,
                                                  @PathVariable String itemStatus,
                                                  UserAuthentication userAuthentication) {
        return itemService.updateItemStatus(id, itemStatus, userAuthentication);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("isAuthenticated() and (hasAuthority('USER') or hasAuthority('ADMIN'))")
    public ItemDeleteResponseDto delete(@PathVariable Long id, UserAuthentication userAuthentication) {
        return itemService.deleteItem(id, userAuthentication);
    }
}
