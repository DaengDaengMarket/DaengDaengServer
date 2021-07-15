package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query("SELECT distinct i FROM Item i LEFT JOIN i.seller seller LEFT JOIN i.buyer buyer " +
            "LEFT JOIN i.itemImageList itemImageList LEFT JOIN i.blameList blameList LEFT JOIN i.wishList wishList " +
            "LEFT JOIN i.review review LEFT JOIN i.chatRoomList chatRoomList")
    Page<Item> findAll(Pageable pageable);

    @Query("SELECT distinct i FROM Item i LEFT JOIN i.seller seller LEFT JOIN i.buyer buyer " +
            "LEFT JOIN i.itemImageList itemImageList LEFT JOIN i.blameList blameList LEFT JOIN i.wishList wishList " +
            "LEFT JOIN i.review review LEFT JOIN i.chatRoomList chatRoomList WHERE i.id = :id")
    Optional<Item> findById(@Param("id") Long id);

    Item save(Item item);

    void delete(Item item);

    @Query("SELECT distinct i FROM Item i LEFT JOIN i.seller seller LEFT JOIN i.buyer buyer " +
            "LEFT JOIN i.itemImageList itemImageList LEFT JOIN i.blameList blameList LEFT JOIN i.wishList wishList " +
            "LEFT JOIN i.review review LEFT JOIN i.chatRoomList chatRoomList WHERE i.seller.id = :id")
    Page<Item> findAllBySellerId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT distinct i FROM Item i LEFT JOIN i.seller seller LEFT JOIN i.buyer buyer " +
            "LEFT JOIN i.itemImageList itemImageList LEFT JOIN i.blameList blameList LEFT JOIN i.wishList wishList " +
            "LEFT JOIN i.review review LEFT JOIN i.chatRoomList chatRoomList WHERE i.buyer.id = :id")
    Page<Item> findAllByBuyerId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT distinct i FROM Item i WHERE i.seller.id = :id")
    List<Item> findAllBySeller(@Param("id") Long id);

    @Query("SELECT distinct i FROM Item i WHERE i.id = :id")
    Optional<Item> findByItemId(@Param("id") Long id);
}
