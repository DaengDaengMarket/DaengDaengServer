package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.Notice;
import com.dignity.puppymarket.dto.NoticeRequestDto;
import com.dignity.puppymarket.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoticeController {

    @Autowired//스프링부트가 알아서 객채 생성및 연결
    private NoticeService noticeService;

    //메인화면 보여주기
    @GetMapping("/notice")
    public List<Notice> viewNotice() {
        return noticeService.viewNotice();
    }

    //새로운 공지만들기
//    @GetMapping("/notice/new")
//    public String newNotice(){
//        return "newNotice";
//    }

    //프론트의 내용 받기
    @PostMapping("/notice")
    public Notice createNotice(@RequestBody NoticeRequestDto form){
        return noticeService.saveNotice(form);
    }



    //수정 게시글 상세보기
    @GetMapping("/notice/{id}")
    public Notice getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }

    @PutMapping("/notice/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto form){
        return noticeService.updateNotice(id, form);
    }


    @DeleteMapping("/notice/{id}")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
    }

}
