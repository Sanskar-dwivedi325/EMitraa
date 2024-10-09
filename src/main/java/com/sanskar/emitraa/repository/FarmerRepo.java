package com.sanskar.emitraa.repository;

import com.sanskar.emitraa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepo extends JpaRepository<Users,Integer> {

    public Users findByUsername(String username);
}
