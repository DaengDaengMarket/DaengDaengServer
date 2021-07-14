package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.Notice;

import com.dignity.puppymarket.dto.NoticeRequestDto;
import com.dignity.puppymarket.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired//스프링부트가 알아서 객채 생성및 연결
    private NoticeService noticeService;

    //메인화면 보여주기
    @GetMapping("/notice")
    public List<Notice> viewNotice() {
        return noticeService.viewNotice();
    }

    //프론트의 내용 받기
    @PostMapping("/admin/notice")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public Notice createNotice(@RequestBody NoticeRequestDto form){
        return noticeService.saveNotice(form);
    }

    //수정 게시글 상세보기
    @GetMapping("/notice/{id}")
    public Notice getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }

    @PutMapping("/admin/notice/{id}")
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto form){
        return noticeService.updateNotice(id, form);
    }

    @DeleteMapping("/admin/notice/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);

    }
}
