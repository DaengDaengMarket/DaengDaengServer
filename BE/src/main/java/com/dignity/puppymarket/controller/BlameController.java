package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Blame.BlameGetResponseDto;
import com.dignity.puppymarket.dto.Blame.BlameRequestDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.BlameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blame")
public class BlameController {

    private final BlameService blameService;

    @GetMapping("")
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    public List<BlameGetResponseDto> viewBlame(UserAuthentication userAuthentication){
        validateAdmin(userAuthentication);
        return blameService.viewBlame();
    }

    @PostMapping("/item/{itemId}")
    //@PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createBlame(@PathVariable Long itemId,
                             @RequestBody BlameRequestDto form,
                             UserAuthentication userAuthentication){
        if(userAuthentication == null) {
            throw new AccessDeniedException("권한이 없습니다");
        }
        return blameService.saveBlame(itemId ,form, userAuthentication);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlame(@PathVariable Long id,
                            UserAuthentication userAuthentication){
        validateAdmin(userAuthentication);
        blameService.deleteBlame(id);
    }

    public void validateAdmin(UserAuthentication userAuthentication) {
        if(userAuthentication == null || !userAuthentication.getEmail().equals("admin")) {
            throw new AccessDeniedException("권한이 없습니다. 어드민만 접근 가능합니다");
        }
    }
}
