package com.robel.capstone;

import com.robel.capstone.model.ProductModel;
import com.robel.capstone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(CapstoneApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		ProductModel productModel1 = new ProductModel( "iphone","iphone13",1000.00,"https://images.unsplash.com/photo-1483985988355-763728e1935b?auto=format&fit=crop&w=1350&h=900&q=80&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-4.0.3");
		productRepository.save(productModel1);

		ProductModel productModel2 = new ProductModel("MacBook", "MacBook Pro", 2500.00, "https://images.unsplash.com/photo-1483985988355-763728e1935b?auto=format&fit=crop&w=1350&h=900&q=80&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-4.0.3");
		productRepository.save(productModel2);
	}

}
