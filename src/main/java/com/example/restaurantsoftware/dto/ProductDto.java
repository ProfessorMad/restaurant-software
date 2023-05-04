package com.example.restaurantsoftware.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Please write product name")
    private String productName;
    @NotEmpty(message = "Please write product price")
    private String category;
    @Positive
    private Double price;
    @NotEmpty(message = "Please write product description")
    private String description;


}
