package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.Blame.BlameGetResponseDto;
import com.dignity.puppymarket.dto.Blame.BlameRequestDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.BlameRepository;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlameService {
    private final BlameRepository blameRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public List<BlameGetResponseDto> viewBlame(){
        return blameRepository.findAll().stream()
                .map(BlameGetResponseDto::of)
                .collect(Collectors.toList());
    }

    public Long saveBlame(Long id, BlameRequestDto form,
                           UserAuthentication userAuthentication){
        Blame requestBlame = form.toEntity();

        //Item 넣기
        Item savedItem = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        requestBlame.addItem(savedItem);

        //User 넣기
        User savedUser = userRepository.findByEmail(userAuthentication.getEmail())
                .orElseThrow(() -> new UserNotFoundException(0L));
        requestBlame.addUser(savedUser);

        Blame blame = blameRepository.save(requestBlame);

        return blame.getId();
    }

    public void deleteBlame(Long id){
        blameRepository.deleteById(id);
    }
}
