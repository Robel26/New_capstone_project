package com.robel.capstone.service;

import com.robel.capstone.model.ProductModel;
import com.robel.capstone.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel getproductById(Long id) {
        return productRepository.findById(id).get();
    }


    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
