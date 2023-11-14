package com.robel.capstone.repository;

import com.robel.capstone.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    Category category;

    @BeforeEach
   public void init() {
        category = new Category();
        category.setName("CategoryName");
        category.setId(1);
    }

    @Test
    public void saveCategory() {
        categoryRepository.save(category);
    }
}