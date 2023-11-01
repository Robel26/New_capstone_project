package com.robel.capstone.repository;

import com.robel.capstone.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
ProductRepository extends JpaRepository<ProductModel, Long> {

}
