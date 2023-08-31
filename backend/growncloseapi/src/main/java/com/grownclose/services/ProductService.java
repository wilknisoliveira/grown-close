package com.grownclose.services;

import com.grownclose.dto.products.ProductDto;
import com.grownclose.exceptions.ResourceNotFoundException;
import com.grownclose.models.Product;
import com.grownclose.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProducerService producerService;

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    public ProductDto save(ProductDto productDto) {
        logger.info("Creating a product...");

        Product product = productDto.dtoToEntity();
        product.setDate(LocalDateTime.now());
        product.setProducer(producerService.findByIdRepo((long) productDto.producerId()));

        Product productResponse = productRepository.save(product);

        ProductDto productDtoResponse = new ProductDto(
                (long) productResponse.getId(),
                productDto.name(),
                productDto.price(),
                productDto.description(),
                productDto.producerId()
        );

        return productDtoResponse;
    }

    public Product FindByIdRepo(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("The user id "+productId+" doesn't exist."));
        return product;
    }
}
