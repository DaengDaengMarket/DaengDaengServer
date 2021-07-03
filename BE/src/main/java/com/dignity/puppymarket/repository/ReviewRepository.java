package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<Review> findById(Long id);

    @Query("SELECT r FROM Review r WHERE r.item.seller.id = :id AND r.item.buyer is NOT NULL")
    Page<Review> findAllReviews(@Param("id") Long id, Pageable pageable);
}
