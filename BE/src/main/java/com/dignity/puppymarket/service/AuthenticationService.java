package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Role;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.AuthenticationCreateDto;
import com.dignity.puppymarket.dto.SessionResponseDto;
import com.dignity.puppymarket.dto.User.UserLoginResponseDto;
import com.dignity.puppymarket.error.AuthenticationBadRequestException;
import com.dignity.puppymarket.error.InvalidTokenException;
import com.dignity.puppymarket.repository.RoleRepository;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.utils.JwtUtil;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 JwtUtil jwtUtil,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public SessionResponseDto createToken(AuthenticationCreateDto authenticationCreateDto) {
        UserLoginResponseDto userLoginResponseDto = authenticateUser(
                authenticationCreateDto.getEmail(),
                authenticationCreateDto.getPassword()
        );

        String token = jwtUtil.encode(userLoginResponseDto.getEmail());

        return SessionResponseDto.of(token);
    }

    public void signup(AuthenticationCreateDto authenticationCreateDto) {
        String email = authenticationCreateDto.getEmail();
        String password = authenticationCreateDto.getPassword();
        User savedUser = authenticateEmailAndPassword(email,password);
        List<Role> roles = roles(email);
        Authentication authentication = new UserAuthentication(email, roles);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public String parseToken(String token) {
        if(token == null || token.isBlank()) {
            throw new InvalidTokenException(token);
        }

        try {
            return jwtUtil.decode(token).getSubject();
        } catch(SignatureException e) {
            throw new InvalidTokenException(token);
        }
    }

    public UserLoginResponseDto authenticateUser(String email, String password) {
        return userRepository.findByEmail(email)
                //.filter(u -> u.authenticate(password, passwordEncoder))
                .map(UserLoginResponseDto::of)
                .orElseThrow(()-> new AuthenticationBadRequestException(email));
    }

    public User authenticateEmailAndPassword(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(()-> new AuthenticationBadRequestException(email));
    }

    public List<Role> roles(String email) {
        return roleRepository.findAllByEmail(email);
    }
}
