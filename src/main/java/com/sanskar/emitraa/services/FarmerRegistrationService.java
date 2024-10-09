package com.sanskar.emitraa.services;

import com.sanskar.emitraa.model.Role;
import com.sanskar.emitraa.model.Users;
import com.sanskar.emitraa.repository.FarmerRepo;
import com.sanskar.emitraa.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FarmerRegistrationService {
  @Autowired
  private FarmerRepo farmerRepo;

  @Autowired
  private RoleRepo roleRepo;

  public Boolean create(Users users) {
      users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

   Role role= roleRepo.findByName("ROLE_USER");
       Set<Role> roles= new HashSet<>();
       roles.add(role);
      users.setRoles(roles);



      try{
         Users user1= farmerRepo.save(users);
         return true;
      }
      catch (Exception e){
          return false;
      }


  }

}
