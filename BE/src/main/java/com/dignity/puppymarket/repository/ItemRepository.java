package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAll();

    @Query("SELECT distinct i FROM Item i LEFT JOIN i.seller seller LEFT JOIN i.buyer buyer " +
            "LEFT JOIN i.itemImageList itemImageList LEFT JOIN i.blameList blameList LEFT JOIN i.wishList wishList " +
            "LEFT JOIN i.review review LEFT JOIN i.chatRoomList chatRoomList WHERE i.id = :id")
    Optional<Item> findById(@Param("id") Long id);
}
