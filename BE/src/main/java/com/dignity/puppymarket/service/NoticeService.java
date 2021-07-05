package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Notice;

import com.dignity.puppymarket.dto.NoticeRequestDto;
import com.dignity.puppymarket.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    public Notice saveNotice(NoticeRequestDto form){
        Notice notice = form.toEntity();
        return noticeRepository.save(notice);
    }

    public List<Notice> viewNotice(){
        return noticeRepository.findAll();
    }

    public Notice getNotice(Long id){
        return noticeRepository.findById(id).get();
    }

    @Transactional
    public Notice updateNotice(Long id, NoticeRequestDto form){
        Notice notice = noticeRepository.findById(id).get();
        Notice updateNotice = form.toEntity();
        notice.update(updateNotice);
        return notice;
    }

    public void deleteNotice(Long id){
        noticeRepository.deleteById(id);
    }

}
