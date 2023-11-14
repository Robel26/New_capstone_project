package com.robel.capstone.service;

import com.robel.capstone.model.Product;
import com.robel.capstone.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){

        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void removeProductById(long id){
        productRepository.deleteById(id);

    }
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }
    public List<Product> getAllProductByCategoryId(int id){

    return productRepository.findAllByCategory_Id(id);
    }
}
