package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.User.UserRequestDto;
import com.dignity.puppymarket.repository.JPAUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JPAUserRepository jpaUserRepository;

    @Test
    @Transactional
    public void 회원가입_API() throws Exception {
        //given
        String email = "ssss@ss.ss";
        String tel = "010234534634";
        UserRequestDto dto = new UserRequestDto();
        UserRequestDto userDto = dto.builder()
                .email(email)
                .password("1234")
                .nickname("닉넴")
                .concern(BigCategory.BIG)
                .tel(tel)
                .build();
        String url = "http://localhost:" + port + "/users";

        //when
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, userDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).hasSizeGreaterThan(0);

        List<User> findUserByEmail = jpaUserRepository.findByEmail(email);
        assertThat(findUserByEmail.get(0).getEmail()).isEqualTo(email);
        assertThat(findUserByEmail.get(0).getTel()).isEqualTo(tel);
    }
}