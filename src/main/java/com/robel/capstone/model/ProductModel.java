package com.robel.capstone.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products_table")
@NoArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private String imageUrl;

    public ProductModel( String productName, String productDescription, Double price, String imageUrl) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public ProductModel() {

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
