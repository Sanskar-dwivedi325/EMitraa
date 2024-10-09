package com.sanskar.emitraa.repository;

import com.sanskar.emitraa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
