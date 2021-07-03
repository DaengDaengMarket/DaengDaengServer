package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends CrudRepository<Notice, Long> {

    List<Notice> findAll();

    Notice save(Notice notice);

    void delete(Notice notice);

    Optional<Notice> findById(Long id);
}

