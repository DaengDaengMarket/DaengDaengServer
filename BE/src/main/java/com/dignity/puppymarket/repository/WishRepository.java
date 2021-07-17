package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Wish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishRepository extends CrudRepository<Wish, Long> {
    @Query("SELECT w FROM Wish w WHERE w.item.id = :itemId AND w.user.id = :userId")
    List<Wish> findAllByItemAndUser(@Param("itemId") Long itemId, @Param("userId") Long userId);

    Wish save(Wish wish);

    void delete(Wish wish);
}
