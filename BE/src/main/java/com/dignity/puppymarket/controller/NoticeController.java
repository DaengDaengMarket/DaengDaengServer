package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.NoticeRequestDto;
import com.dignity.puppymarket.dto.NoticeResponseDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired//스프링부트가 알아서 객채 생성및 연결
    private NoticeService noticeService;

    //공지글 리스트 조회
    @GetMapping
    public List<NoticeResponseDto> viewNotice() {
        return noticeService.viewNotice();
    }

    //공지글 상세조회
    @GetMapping("/{id}")
    public NoticeResponseDto getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }

    //공지글 수정
    @PutMapping("/{id}")
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    public NoticeResponseDto updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto form,
                                          UserAuthentication userAuthentication){
        validateAdmin(userAuthentication);
        return noticeService.updateNotice(id, form);
    }

    //공지글 저장
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    public NoticeResponseDto createNotice(@RequestBody NoticeRequestDto form,
                                          UserAuthentication userAuthentication){
        validateAdmin(userAuthentication);
        return noticeService.saveNotice(form);
    }

    //공지글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    public void deleteNotice(@PathVariable Long id,
                             UserAuthentication userAuthentication) {
        validateAdmin(userAuthentication);
        noticeService.deleteNotice(id);
    }

    public void validateAdmin(UserAuthentication userAuthentication) {
        if(userAuthentication == null || !userAuthentication.getEmail().equals("admin")) {
            throw new AccessDeniedException("권한이 없습니다. 어드민만 접근 가능합니다");
        }
    }
}
