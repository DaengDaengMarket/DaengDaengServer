package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.ItemStatus;
import com.dignity.puppymarket.domain.MidCategory;
import com.dignity.puppymarket.domain.Pagination;
import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.domain.Wish;
import com.dignity.puppymarket.domain.WishStatus;
import com.dignity.puppymarket.dto.Item.*;
import com.dignity.puppymarket.dto.WishResponseDto;
import com.dignity.puppymarket.error.ItemNotFoundException;
import com.dignity.puppymarket.error.LocationNotFoundException;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.ItemRepository;
import com.dignity.puppymarket.repository.JpaItemRepository;
import lombok.RequiredArgsConstructor;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.repository.WishRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final JpaItemRepository jpaItemRepository;
    private final UserRepository userRepository;
    private final WishRepository wishRepository;

    public List<ItemResponseDto> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable).stream()
                .map(ItemResponseDto::of)
                .collect(Collectors.toList());
    }

    public List<ItemHomeGetResponseDto> getHomeItems(Pageable pageable) {
        return itemRepository.findAll(pageable).stream()
                .map(ItemHomeGetResponseDto::of)
                .collect(Collectors.toList());
    }

    public Pagination getHomeItemsPagination(Pageable pageable) {

        return Pagination.itemWith(itemRepository.findAll(pageable));
    }

    public ItemGetResponseDto getItem(Long id) {
        Item savedItem = findItem(id);
        savedItem.addHit();
        return ItemGetResponseDto.of(savedItem);
    }

    public ItemCreateResponseDto createItem(ItemCreateRequestDto itemCreateRequestDto,
                                            UserAuthentication userAuthentication) {
        String userEmail = userAuthentication.getEmail();
        User savedUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(0L));
        if(savedUser.getSi() == null || savedUser.getGu() == null) {
            throw new LocationNotFoundException("동네인증을 먼저 해야합니다");
        }

        Item item = itemCreateRequestDto.toEntity();
        item.addLocation(savedUser.getSi(), savedUser.getGu());
        Item savedItem = itemRepository.save(item);
        return ItemCreateResponseDto.of(savedItem);
    }

    public ItemUpdateResponseDto updateItem(Long id,
                                            ItemUpdateRequestDto itemUpdateRequestDto,
                                            UserAuthentication userAuthentication) {
        validateUser(id, userAuthentication);

        Item item = findItem(id);

        item.updateWith(itemUpdateRequestDto);

        return ItemUpdateResponseDto.of(item);
    }

    public ItemUpdateResponseDto updateItemStatus(Long id, String itemStatusString,
                                                  UserAuthentication userAuthentication) {
        validateUser(id, userAuthentication);

        Item item = findItem(id);
        ItemStatus itemStatus = ItemStatus.findByItemStatusCode(itemStatusString);
        item.updateItemStatus(itemStatus);

        return ItemUpdateResponseDto.of(item);
    }

    public ItemDeleteResponseDto deleteItem(Long id, UserAuthentication userAuthentication) {
        validateUser(id, userAuthentication);

        Item item = findItem(id);

        itemRepository.delete(item);

        return ItemDeleteResponseDto.of(item);
    }

    public void validateUser(Long id, UserAuthentication userAuthentication) {
        String userEmail = userAuthentication.getEmail();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(0L));
        List<Item> sellItems = itemRepository.findAllBySeller(user.getId());
        sellItems.stream()
                .filter(item -> item.getSeller().getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AccessDeniedException("권한이 없습니다"));
    }

    public Item findItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<ItemCategoryGetResponseDto> getCategoryItem(Long id, String name) {
        return  jpaItemRepository.getItemsInCategory(id, name).stream()
                .map(item -> ItemCategoryGetResponseDto.of(item))
                .collect(Collectors.toList());
    }

    public List<ItemCategoryGetResponseDto> search(ItemSearchCondition condition, int page, int size) {
        return jpaItemRepository.search(condition, page, size);
    }
}
