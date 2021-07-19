package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.dto.Advertise.AdvertiseRequestDto;
import com.dignity.puppymarket.dto.Advertise.AdvertiseResponseDto;
import com.dignity.puppymarket.dto.Advertise.AdvertiseUpdateRequestDto;
import com.dignity.puppymarket.security.UserAuthentication;
import com.dignity.puppymarket.service.AdvertiseService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/advertise")
public class AdvertiseController {
    private final AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

    @GetMapping
    public List<AdvertiseResponseDto> list() {
        return advertiseService.getAdvertises();
    }

    @PostMapping
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public AdvertiseResponseDto create(@RequestBody AdvertiseRequestDto advertiseRequestDto,
                                       UserAuthentication userAuthentication) {
        validateAdmin(userAuthentication);
        return advertiseService.createAdvertise(advertiseRequestDto);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    public AdvertiseResponseDto update(@PathVariable Long id,
                                       @RequestBody AdvertiseUpdateRequestDto advertiseUpdateRequestDto,
                                       UserAuthentication userAuthentication) {
        validateAdmin(userAuthentication);
        return advertiseService.updateAdvertise(id, advertiseUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AdvertiseResponseDto delete(@PathVariable Long id,
                                       UserAuthentication userAuthentication) {
        validateAdmin(userAuthentication);
        return advertiseService.deleteAdvertise(id);
    }

    public void validateAdmin(UserAuthentication userAuthentication) {
        if(userAuthentication == null || !userAuthentication.getEmail().equals("admin")) {
            throw new AccessDeniedException("권한이 없습니다. 어드민만 접근 가능합니다");
        }
    }
}
