package com.grownclose.application.product.dto;

import com.grownclose.domain.products.Product;

public record ProductDto(Long id, String name, float price, String description, int producerId) {
    public Product dtoToEntity() {
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
        product.setDescription(this.description);

        return product;
    }
}
