package com.robel.capstone.controller;


import com.robel.capstone.model.ProductModel;
import com.robel.capstone.service.ProductService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;




@Controller

public class ProductController {
//    @Value("")
//    private String uploadDirectory;
    private final ProductService productService;

    public ProductController( ProductService productService) {
//        this.uploadDirectory = uploadDirectory;
        this.productService = productService;
    }

    //handler method to handle list of products and return model and view
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    //create product object to hold product from data
    @GetMapping("/products/new")
    public  String createProductForm(Model model) {
       //create product object to hold product from data
        ProductModel product = new ProductModel();

        model.addAttribute("product", product);
        return "create_product";

    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") ProductModel product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
//    public String saveProduct(
//            @ModelAttribute("product") ProductModel product,
//            @RequestParam("imageUrl") MultipartFile imageFile
//    ) throws IOException {
//        if (!imageFile.isEmpty()) {
//            String fileName = StringUtils.cleanPath(Objects.requireNonNull(imageFile.getOriginalFilename()));
//            product.setImageUrl(fileName); // Set the image file name in the ProductModel
//            productService.saveProduct(product);
//
//            String uploadPath = uploadDirectory + product.getProductId();
//            FileUpload.saveFile(uploadPath, fileName, imageFile);
//        }
//
//        return "redirect:/products";
//    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getproductById(id));
        return "update_product";


    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") ProductModel product, Model model) {
      //get product by id
        ProductModel existingProduct = productService.getproductById(id);
//        existingProduct.setProductId(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageUrl(product.getImageUrl());

        //save updated product
        productService.updateProduct(existingProduct);
        return "redirect:/products";


    }

    //handler method to handle delete product
    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";

    }
//    @PostMapping("/products/save")
//    public String saveProduct(ProductModel productModel, @RequestParam("imageUrl") MultipartFile multipartFile) throws IOException {
//        if(multipartFile.isEmpty()) {
//            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//            productModel.setImageUrl(fileName);
//            productService.saveProduct(productModel);
//            String upload = "images/" + productModel.getProductId();
//
//            FileUpload.saveFile(upload, fileName, multipartFile);
//        }else {
//            if(productModel.getImageUrl().isEmpty()){
//                productModel.setImageUrl(null);
//                productService.saveProduct(productModel);
//
//            }
//        }
//        productService.saveProduct(productModel);
//        return "redirect:/products";
//    }


}
