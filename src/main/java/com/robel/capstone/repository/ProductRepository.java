package com.robel.capstone.repository;

import com.robel.capstone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * author: Robel
 * This class has a method findAllByCategory_Id that takes an integer id as a parameter and returns a list of Product objects.
 * It is likely a method in a class that interacts with a database or some other data source to retrieve all
 * products associated with a specific category ID.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory_Id(int id);
}
