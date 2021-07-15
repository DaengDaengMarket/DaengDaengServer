package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.dto.Advertise.AdvertiseResponseDto;
import com.dignity.puppymarket.dto.HomeResponseDto;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.service.AdvertiseService;
import com.dignity.puppymarket.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final ItemService itemService;
    private final AdvertiseService advertiseService;

    public HomeController(ItemService itemService, AdvertiseService advertiseService) {
        this.itemService = itemService;
        this.advertiseService = advertiseService;
    }

    @GetMapping("/")
    public HomeResponseDto Home(
            @PageableDefault(direction = Sort.Direction.DESC, size = 12, sort = "id") Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String keyword) {
        List<ItemHomeGetResponseDto> itemList = itemService.getHomeItems(pageable, keyword);
        List<AdvertiseResponseDto> advertiseList = advertiseService.getAdvertises();
        Pagination pagination = itemService.getHomeItemsPagination(pageable, keyword);
        return HomeResponseDto.of(itemList, advertiseList, pagination);
    }
}
