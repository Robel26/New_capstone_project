package com.robel.capstone.repository;

import com.robel.capstone.model.Role;
import com.robel.capstone.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Optional;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class UserRepositoryTest {

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
    @Order(1)
    public void testSaveUser() {
        userRepository.save(user);
        Assertions.assertTrue(userRepository.count()>0);
        userRepository.save(user);

    }

    @Test
    void findUserByEmail() {
        userRepository.findByEmail("test@test.com");
    }


}