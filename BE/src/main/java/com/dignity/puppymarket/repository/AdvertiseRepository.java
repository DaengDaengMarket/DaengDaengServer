package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Advertise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertiseRepository extends CrudRepository<Advertise, Long> {
    List<Advertise> findAll();

    Advertise save(Advertise advertise);
}
