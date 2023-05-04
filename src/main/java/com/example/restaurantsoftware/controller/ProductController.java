package com.example.restaurantsoftware.controller;
import com.example.restaurantsoftware.dto.ProductDto;
import com.example.restaurantsoftware.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    public enum categoryList {
        Drinks, Food, Other;
    }
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // handler method to handle list of products requests
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
                return "products";
    }
    @GetMapping("/menu")
    public String menu(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "menu";
    }
    @GetMapping("/test") // tests
    public String test(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "test";
    }

    // method to create new products
    @GetMapping("/products/new")
    public String newProduct(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("product", productDto);
        List<categoryList> listCategory = Arrays.asList(categoryList.Drinks, categoryList.Food, categoryList.Other);
        model.addAttribute("listCategory", listCategory);
        return "add_product";
    }

     //method to save new prodcuts
    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDto product,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("product", product);
            return "add_product";
        }
        productService.createProduct(product);
        return "redirect:/products";
    }

    //edit product

    @GetMapping("/products/{productId}/edit/")
    public String editProduct(@PathVariable("productId") Long productId,
                               Model model) {
        ProductDto product= productService.getProductById(productId);
        model.addAttribute("product", product);
        List<categoryList> listCategory = Arrays.asList(categoryList.Drinks, categoryList.Food, categoryList.Other);
        model.addAttribute("listCategory", listCategory);

        return  "edit_product";
    }

    // method to edit product from submit request
    @PostMapping("/products/{productId}")
    public  String updateProduct(@PathVariable("productId") Long productId,
                                 @Valid @ModelAttribute("product") ProductDto productDto,
                                  BindingResult result,
                                 Model model) {
        if(result.hasErrors()) {
             model.addAttribute("product", productDto);
             return "edit_product";
        }
        productDto.setId(productId);
        productService.updateProduct(productDto);
        return "redirect:/products";
    }

    //Delete products

    @GetMapping("/products/{productId}/delete")
    public String deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return "redirect:/products";
    }
    // handler to view products
    @GetMapping("/products/{productId}/view")
    public String viewProduct(@PathVariable("productId") Long productId,
                              Model model){
        ProductDto productDto = productService.getProductById(productId);
        model.addAttribute("product", productDto);
        return "view_product";
    }

}
