package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAll();
}
