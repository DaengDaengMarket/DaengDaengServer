package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.Notice;
import com.dignity.puppymarket.dto.NoticeResponseDto;
import com.dignity.puppymarket.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired//스프링부트가 알아서 객채 생성및 연결
    private NoticeService noticeService;

    //메인화면 보여주기
    @GetMapping("/notice")
    public String viewNotice(Model model) {
        List<Notice> notice = noticeService.viewNotice();
        model.addAttribute("notice", notice);
        return "notice";
    }

    //새로운 공지만들기
    @GetMapping("/notice/new")
    public String newNotice(){
        return "newNotice";
    }

    //프론트의 내용 받기
    @PostMapping("/notice")
    public String createNotice(NoticeResponseDto form){

        Notice saved = noticeService.saveNotice(form);
        return "redirect:/notice";
    }



    //수정 게시글 상세보기
    @GetMapping("/notice/{id}")
    public String getNotice(@PathVariable Long id, Model model) {
        Notice notice = noticeService.getNotice(id);
        model.addAttribute("notice", notice);

        return "noticeUpdateForm";
    }

    @PutMapping("/notice/{id}")
    public void updateNotice(@PathVariable Long id, NoticeResponseDto form){
        noticeService.updateNotice(id, form);
    }



    @DeleteMapping("/notice/{id}")
    public String deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return "/notice";
    }

}
