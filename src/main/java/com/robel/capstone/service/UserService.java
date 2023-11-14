package com.robel.capstone.service;

import com.robel.capstone.dto.UserDTO;
import com.robel.capstone.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User save(UserDTO userDTO);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
