package com.robel.capstone.controller;

import com.robel.capstone.global.GlobalData;
import com.robel.capstone.service.CategoryService;
import com.robel.capstone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
This section is HomeController to control the home page of the website
which is a user navigate to different pages.
a user can see all products and categories on the home page also can navigate to shop page to shop product and filter by category
and view details the product with the different pages
*/

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home( Model model) {
        model.addAttribute("categories", categoryService.getAllCategories()); // get all categories
        model.addAttribute("products", productService.getAllProduct()); // get all products
        model.addAttribute("cartCount", GlobalData.cart.size());
        GlobalData.cart.clear();
        return "index";
    }
    @GetMapping("/shop")
    public String shop( Model model) {
        model.addAttribute("categories", categoryService.getAllCategories()); // get all categories
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products", productService.getAllProduct()); // get all products
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shop( Model model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.getAllCategories()); // get all categories
        model.addAttribute("products", productService.getAllProductByCategoryId(id)); // get all products
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
    @GetMapping("/shop/viewProduct/{id}")
    public String viewProduct( Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get()); // get all products
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }
    @GetMapping("/contact")
    public String contact( Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "contactUs";
    }

    @GetMapping("/about")
    public String about( Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "about";
    }

}
