package com.sanskar.emitraa.services;

import com.sanskar.emitraa.model.Users;
import com.sanskar.emitraa.repository.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustumUserService implements UserDetailsService {

    @Autowired
    private FarmerRepo farmerRepo;


            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Users user = farmerRepo.findByUsername(username);

                Set<GrantedAuthority> grantedAuthorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return grantedAuthorities;
                    }

                    @Override
                    public String getPassword() {
                        return
                                user.getPassword();
                    }

                    @Override
                    public String getUsername() {
                        return username;
                    }
                };

            }

}
