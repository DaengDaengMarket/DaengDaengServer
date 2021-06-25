package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.User.UserRequestDto;
import com.dignity.puppymarket.error.DuplicateUserException;
import com.dignity.puppymarket.dto.User.UserResponseDto;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.JPAUserRepository;
import com.dignity.puppymarket.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JPAUserRepository jpaUserRepository;

    public UserService(UserRepository userRepository, JPAUserRepository jpaUserRepository) {
        this.userRepository = userRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    public UserResponseDto getUser(Long id) {
        return userRepository.findById(id)
                .map(UserResponseDto::of)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 회원가입
     * author: 송영섭
     * @param userDto
     * @return
     */
    @Transactional
    public String join(UserRequestDto userDto) {
        validateDuplicationUser(userDto);
        jpaUserRepository.save(userDto.toEntity());
        return userDto.getEmail();
    }

    /**
     * 회원 이메일 중복 체크
     * author: 송영섭
     * @param userDto
     */
    private void validateDuplicationUser(UserRequestDto userDto) {
        String email = userDto.getEmail();
        List<User> findUsers = jpaUserRepository.findByEmail(email);
        if (!findUsers.isEmpty()) {
            throw new DuplicateUserException(email);
        }
    }
}
