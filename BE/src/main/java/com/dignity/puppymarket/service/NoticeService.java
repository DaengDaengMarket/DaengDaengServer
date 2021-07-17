package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Notice;

import com.dignity.puppymarket.dto.NoticeRequestDto;
import com.dignity.puppymarket.dto.NoticeResponseDto;
import com.dignity.puppymarket.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    public NoticeResponseDto saveNotice(NoticeRequestDto form){
        Notice notice = form.toEntity();
        Notice savedNotice = noticeRepository.save(notice);
        return NoticeResponseDto.of(savedNotice);
    }

    public List<NoticeResponseDto> viewNotice(){
        return noticeRepository.findAll().stream()
                .map(NoticeResponseDto::of)
                .collect(Collectors.toList());
    }

    public NoticeResponseDto getNotice(Long id){
        return noticeRepository.findById(id)
                .map(NoticeResponseDto::of)
                .get();
    }

    @Transactional
    public NoticeResponseDto updateNotice(Long id, NoticeRequestDto form){
        Notice notice = noticeRepository.findById(id).get();
        Notice updateNotice = form.toEntity();
        notice.update(updateNotice);
        return NoticeResponseDto.of(notice);
    }

    public void deleteNotice(Long id){
        noticeRepository.deleteById(id);
    }

}
