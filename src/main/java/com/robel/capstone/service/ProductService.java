package com.robel.capstone.service;

import com.robel.capstone.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getAllProducts();

    ProductModel saveProduct(ProductModel productModel);

    ProductModel getproductById(Long id);

    ProductModel updateProduct(ProductModel productModel);

    void deleteProductById(Long id);

}
