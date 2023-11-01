package com.robel.capstone.repository;

import com.robel.capstone.model.UsersModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;




@SpringBootTest
public class UsersRepositoryTest {
    @Autowired
     UsersRepository usersRepository;




    @Test
    public void testCreateNewUser() {






    }


}