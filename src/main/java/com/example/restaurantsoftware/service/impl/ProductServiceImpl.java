package com.example.restaurantsoftware.service.impl;

import com.example.restaurantsoftware.dto.ProductDto;
import com.example.restaurantsoftware.entity.Product;
import com.example.restaurantsoftware.mapper.ProductMapper;
import com.example.restaurantsoftware.repository.ProductRepository;
import com.example.restaurantsoftware.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> ProductDtos = products.stream()
                .map((product) -> ProductMapper.mapToProductDto(product))
                        .collect(Collectors.toList());
        return ProductDtos;
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).get();
        ProductDto productDto = ProductMapper.mapToProductDto(product);
        return productDto;
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        productRepository.save(ProductMapper.mapToProduct(productDto));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
