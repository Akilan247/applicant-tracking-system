package com.akilan.application_tracking_system.Service;

import com.akilan.application_tracking_system.Entity.Users;
import com.akilan.application_tracking_system.Repo.UserDetailsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsJpaRepository userDetailsJpaRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDetailsJpaRepository
                .findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found..!"));
    }
}
