package com.robel.capstone.repository;

import com.robel.capstone.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    Role role;
    @BeforeEach
    public void init() {
        role = new Role();
        role.setName("ADMIN_ROLE");
    }

    @Test
    void saveRole() {
        roleRepository.save(role);
    }
    @Test
    void findRoleByName() {
        roleRepository.findRoleByName("ADMIN_ROLE");
    }

    @Test
    void findRoleByUser() {
        roleRepository.findRoleByUser(1L);
    }
}