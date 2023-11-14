package com.robel.capstone.service;


import com.robel.capstone.dto.UserDTO;
import com.robel.capstone.model.Role;
import com.robel.capstone.model.User;
import com.robel.capstone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleService roleService;

    private BCryptPasswordEncoder passwordEncoder;



    public UserServiceImpl(UserRepository userRepository, RoleService roleService, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);


    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   System.out.println("username: " + username);
       User user = userRepository.findByEmail(username);
       if(user == null){
           throw new UsernameNotFoundException("Invalid username or password.");

       }
       System.out.println(user.getEmail());
       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
