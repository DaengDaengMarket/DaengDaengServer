package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.MyPage.MyPageGetResponseDto;
import com.dignity.puppymarket.service.MyPageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/{id}/{menu}")
    public MyPageGetResponseDto detail(
            @PageableDefault(direction = Sort.Direction.DESC, size = 12, sort = "id") Pageable pageable,
            @PathVariable Long id,
            @PathVariable String menu) {
        return myPageService.getMyPageInfo(id, menu, pageable);
    }
}
