package com.grownclose.domain.products;

import com.grownclose.application.product.dto.ProductDto;
import com.grownclose.application.product.dto.ProductResumeDto;
import com.grownclose.domain.producers.ProducerService;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
                .orElseThrow(() -> new ResourceNotFoundException("The product id "+productId+" doesn't exist."));
        return product;
    }

    public List<ProductResumeDto> GetResumeList(Long producerId) {
        producerService.findByIdRepo(producerId);

        return productRepository.getResumeList(producerId.intValue());
    }
}
