package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAllByEmail(String email);
}
