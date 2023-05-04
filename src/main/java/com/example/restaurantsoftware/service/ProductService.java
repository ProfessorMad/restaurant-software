package com.example.restaurantsoftware.service;

import com.example.restaurantsoftware.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<ProductDto> getAllProducts();
    void createProduct(ProductDto product);
    ProductDto getProductById(Long productId);
    void updateProduct(ProductDto productDto);
    void deleteProduct(Long productId);
}