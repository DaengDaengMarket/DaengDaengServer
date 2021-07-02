package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.AdvertiseResponseDto;
import com.dignity.puppymarket.dto.HomeResponseDto;
import com.dignity.puppymarket.dto.Item.ItemHomeGetResponseDto;
import com.dignity.puppymarket.service.AdvertiseService;
import com.dignity.puppymarket.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public HomeResponseDto Home() {
        List<ItemHomeGetResponseDto> itemList = itemService.getHomeItems();
        List<AdvertiseResponseDto> advertiseList = advertiseService.getAdvertises();
        return HomeResponseDto.of(itemList, advertiseList);
    }
}
