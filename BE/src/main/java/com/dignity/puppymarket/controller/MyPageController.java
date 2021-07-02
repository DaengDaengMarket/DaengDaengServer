package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.MyPageGetResponseDto;
import com.dignity.puppymarket.service.MyPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    };

    @GetMapping("/{id}")
    public MyPageGetResponseDto detail(@PathVariable Long id) {
        return myPageService.getMyPage(id);
    }
}
