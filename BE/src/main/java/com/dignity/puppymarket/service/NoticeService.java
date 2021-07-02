package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Notice;
import com.dignity.puppymarket.dto.NoticeResponseDto;
import com.dignity.puppymarket.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public Notice saveNotice(NoticeResponseDto form){
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
    public void updateNotice(Long id,NoticeResponseDto form){
        Notice notice = noticeRepository.findById(id).get();
        Notice updateNotice = form.toEntity();
        notice.update(updateNotice);
    }


    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}
