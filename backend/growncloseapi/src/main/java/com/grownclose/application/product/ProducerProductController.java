package com.grownclose.application.product;

import com.grownclose.application.product.dto.ProductResumeDto;
import com.grownclose.application.product.dto.ProductDto;
import com.grownclose.domain.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/producer/products")
public class ProducerProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    private ProductDto create(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping("/resumeList/{producerId}")
    private List<ProductResumeDto> readResumeList(@PathVariable UUID producerId) {
        return productService.GetResumeList(producerId);
    }
}
