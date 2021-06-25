package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.UserRequestDto;
import com.dignity.puppymarket.error.DuplicateUserException;
import com.dignity.puppymarket.repository.JPAUserRepository;
import com.dignity.puppymarket.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    JPAUserRepository jpaUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("회원가입 후 특정 이메일을 가진 회원은 한명이다")
    @Transactional
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        UserRequestDto dto = new UserRequestDto();
        UserRequestDto userDto = dto.builder()
                .email("sss@ss.ss")
                .password("1234")
                .nickname("닉넴")
                .concern(BigCategory.BIG)
                .tel("010234534634")
                .build();

        //when
        String email = userService.join(userDto);

        //then
        em.flush();
        List<User> findUserByEmail = jpaUserRepository.findByEmail(email);
        assertThat(1).isEqualTo(findUserByEmail.size());
    }

    @Test
    @DisplayName("같은 이메일을 가진 회원은 존재할 수 없다")
    @Transactional
    public void 중복_회원_예외() {
        //given
        UserRequestDto dto1 = new UserRequestDto();
        UserRequestDto userDto1 = dto1.builder()
                .email("sss@ss.ss")
                .password("1234")
                .nickname("닉넴")
                .concern(BigCategory.BIG)
                .tel("010234534634")
                .build();

        UserRequestDto dto2 = new UserRequestDto();
        UserRequestDto userDto2 = dto2.builder()
                .email("sss@ss.ss")
                .password("1356")
                .nickname("야너두")
                .concern(BigCategory.MID)
                .tel("01055555555")
                .build();

        //when
        userService.join(userDto1);
        DuplicateUserException e = assertThrows(DuplicateUserException.class, () -> userService.join(userDto2));
        assertThat(e.getMessage()).isEqualTo(userDto2.getEmail() + "은 이미 사용중인 이메일입니다.");
    }
}