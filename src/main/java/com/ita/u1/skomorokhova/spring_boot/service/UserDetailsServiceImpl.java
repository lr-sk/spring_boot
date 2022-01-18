package com.ita.u1.skomorokhova.spring_boot.service;

import com.ita.u1.skomorokhova.spring_boot.dao.UserRepository;
import com.ita.u1.skomorokhova.spring_boot.model.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User
                .withUsername(userEntity.getEmail()).password(userEntity.getPassword()).authorities(userEntity.getRole()).build();
        return user;
    }
}
