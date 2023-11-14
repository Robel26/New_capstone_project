package com.robel.capstone.service;

import com.robel.capstone.model.Role;
import com.robel.capstone.model.User;
import com.robel.capstone.repository.RoleRepository;
import com.robel.capstone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    User user;

    Role role;


    @BeforeEach
    public void init() {
        role = new Role();
        role.setName("ROLE_USER");
        roleRepository.save(role);

        user = new User();
        user.setFirstName("Robel");
        user.setLastName("Alemayehu");
        user.setEmail("test@test.com");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));

    }

    @Test
   public void saveUser() {
        userRepository.save(user);
    }
}