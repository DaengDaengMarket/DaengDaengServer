package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Role;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.User.UserRequestDto;
import com.dignity.puppymarket.dto.User.UserResponseDto;
import com.dignity.puppymarket.error.DuplicateUserException;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.JPAUserRepository;
import com.dignity.puppymarket.repository.RoleRepository;
import com.dignity.puppymarket.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JPAUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, JPAUserRepository jpaUserRepository,
                       PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public UserResponseDto getUser(Long id) {
        return userRepository.findById(id)
                .map(UserResponseDto::of)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 이메일, 비밀번호, 닉네임, 관심사, 전화번호를 입력받아 회원가입하고 이메일을 리턴한다
     *
     * author: 송영섭
     * @param userDto - 저장하고자 하는 회원 정보
     * @return - 저장된 회원 이메일
     */
    @Transactional
    public String join(UserRequestDto userDto) {
        validateDuplicationUser(userDto);
        User user = userDto.toEntity();
        jpaUserRepository.save(user);
        user.updatePassword(user.getPassword(), passwordEncoder);
        roleRepository.save(new Role(user.getEmail(), "USER"));
        return userDto.getEmail();
    }

    /**
     * 같은 이메일로 회원가입이 되어 있는지 중복을 체크한다
     *
     * author: 송영섭
     * @param userDto - 저장하고자 하는 회원 정보
     */
    private void validateDuplicationUser(UserRequestDto userDto) {
        String email = userDto.getEmail();
        List<User> findUsers = jpaUserRepository.findByEmail(email);
        if (!findUsers.isEmpty()) {
            throw new DuplicateUserException(email);
        }
    }
}
