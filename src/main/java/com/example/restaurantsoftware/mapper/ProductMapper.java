package com.example.restaurantsoftware.mapper;

import com.example.restaurantsoftware.dto.ProductDto;
import com.example.restaurantsoftware.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription()
        );
        return productDto;
    }
    public static Product mapToProduct(ProductDto productDto){
        Product product = new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getCategory(),
                productDto.getPrice(),
                productDto.getDescription()
        );
                return product;
    }
}
