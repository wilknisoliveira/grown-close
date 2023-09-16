package com.grownclose.domain.boosts;

import com.grownclose.application.boost.dto.BoostDto;
import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.affiliated.AffiliatedService;
import com.grownclose.domain.products.Product;
import com.grownclose.domain.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BoostService {
    @Autowired
    private BoostRepository boostRepository;

    @Autowired
    private AffiliatedService affiliatedService;

    @Autowired
    private ProductService productService;

    private final Logger logger = Logger.getLogger(BoostService.class.getName());

    public BoostDto save(BoostDto boostDto) {
        logger.info("Generating a boost...");

        Affiliated affiliated = affiliatedService.findByIdRepo(boostDto.affiliatedId());
        Product product = productService.FindByIdRepo(boostDto.productId());

        Boost boost = boostDto.dtoToEntity(affiliated, product);

        Boost boostResponse = boostRepository.save(boost);
        BoostDto boostDtoResponse = new BoostDto(boostResponse);

        return boostDtoResponse;
    }

}
