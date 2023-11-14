package com.robel.capstone.controller;


import com.robel.capstone.dto.*;
import com.robel.capstone.model.Category;
import com.robel.capstone.model.Product;
import com.robel.capstone.service.CategoryService;
import com.robel.capstone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
This section is for the admin controller. as the admin you can add, update, delete categories and products
I used the @Controller annotation to make this class a controller
Autowired is used to inject the CategoryService and ProductService.
also used @GetMapping and @PostMapping to make the methods get and post
additionally used @ModelAttribute to get the data from the HTML.
files reader to read the files and store them in relative path

**/
@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/capstone/src/main/resources/static/productImages";

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCategories( Model model) {
        model.addAttribute("categories", categoryService.getAllCategories()); // get all categories-HTMl loop through and add to model
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new Category()); // create a new category object from service  addCategory HTML-categoriesAdd
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category); // create a new category object from-HTML service addCategory
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        return "404";
    }

    // Protected Controller Section Start here

    @GetMapping("/admin/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());

        return "products";
    }
    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "productsAdd";
    }


//    this Post method is used to add a new product form submit button
    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
     Product product = productService.getProductById(id).get();
     ProductDTO productDTO = new ProductDTO();
     productDTO.setId(product.getId());
     productDTO.setName(product.getName());
     productDTO.setCategoryId(product.getCategory().getId());
     productDTO.setPrice(product.getPrice());
     productDTO.setDescription(product.getDescription());
     productDTO.setImageName(product.getImageName());
     model.addAttribute("categories", categoryService.getAllCategories());
     model.addAttribute("productDTO", productDTO);
        return "productsAdd";

    }








}
