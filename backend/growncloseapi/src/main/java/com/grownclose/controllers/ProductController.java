package com.grownclose.controllers;

import com.grownclose.dto.products.ProductDto;
import com.grownclose.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    private ProductDto create(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }
}