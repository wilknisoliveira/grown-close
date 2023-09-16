package com.grownclose.application.product.dto;

import com.grownclose.domain.products.Product;

import java.util.UUID;

public record ProductDto(UUID id, String name, float price, String description, UUID producerId) {
    public Product dtoToEntity() {
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
        product.setDescription(this.description);

        return product;
    }
}
