package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.domain.Wish;
import com.dignity.puppymarket.domain.WishStatus;
import com.dignity.puppymarket.dto.WishResponseDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.repository.WishRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    private final WishRepository wishRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public WishService(WishRepository wishRepository,
                       ItemRepository itemRepository,
                       UserRepository userRepository) {
        this.wishRepository = wishRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public WishResponseDto updateWishStatus(Long id, String wishStatusString, UserAuthentication userAuthentication) {
        String userEmail = userAuthentication.getEmail();
        User savedUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(0L));

        Item savedItem = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        List<Wish> wishList = wishRepository.findAllByItemAndUser(id, savedUser.getId());

        if(wishList.size() == 0) {
            Wish wish = Wish.builder().build();
            wishRepository.save(wish);
            wish.addItem(savedItem);
            wish.addUser(savedUser);
            return WishResponseDto.of(wish);
        }

        Wish savedWish = wishList.get(0);
        WishStatus wishStatus = WishStatus.findByWishStatusCode(wishStatusString);
        savedWish.updateWishStatus(wishStatus);
        return WishResponseDto.of(savedWish);
    }
}
