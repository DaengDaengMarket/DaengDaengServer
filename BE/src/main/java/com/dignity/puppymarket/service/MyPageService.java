package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.MyPageGetResponseDto;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {
    private final UserRepository userRepository;

    public MyPageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyPageGetResponseDto getMyPage(Long id) {
        return userRepository.findById(id)
                .map(MyPageGetResponseDto::of)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
