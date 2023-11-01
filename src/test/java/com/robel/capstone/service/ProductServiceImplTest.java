package com.robel.capstone.service;

import com.robel.capstone.model.ProductModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ProductServiceImplTest {
    @Autowired
ProductService productService;
    @Test
    void saveProduct() {
        ProductModel product = new ProductModel();
        productService.saveProduct(product);





    }

    @Test
    void getproductById() {
    }
}