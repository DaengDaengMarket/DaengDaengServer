package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends CrudRepository<Notice, Long> {

    List<Notice> findAll();

    Optional<Notice> findById(Long id);

    void deleteById(Long id);


}

