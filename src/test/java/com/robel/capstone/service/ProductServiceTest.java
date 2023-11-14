package com.robel.capstone.service;

import com.robel.capstone.model.Category;
import com.robel.capstone.model.Product;
import com.robel.capstone.repository.CategoryRepository;
import com.robel.capstone.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class ProductServiceTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    EntityManager entityManager; // Autowire the EntityManager

    Product product;
    Category category;
    @BeforeEach
    public void init() {
        product = new Product();
        product.setName("test");


        category = entityManager.find(Category.class, 1);
        if (category == null) {
            category = new Category();
            category.setId(1);
            category.setName("CategoryName");

        }

        product.setCategory(category);

        product.setPrice(100);
        product.setDescription("TEST DESCRIPTION");
    }

    @Test

    @Order(1)
    @Transactional
    void saveProduct() {
        Product savedProduct = productRepository.save(product);
    }

    @Test
    void getAllProduct() {
        productRepository.findAll();
    }
}