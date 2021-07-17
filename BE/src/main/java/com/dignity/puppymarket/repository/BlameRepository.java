package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Blame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlameRepository extends CrudRepository<Blame, Long> {

    List<Blame> findAll();

    Blame save(Blame blame);

    Optional<Blame> findById(Long id);
}
