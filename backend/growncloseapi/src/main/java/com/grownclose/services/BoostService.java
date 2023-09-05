package com.grownclose.services;

import com.grownclose.dto.boosts.BoostDto;
import com.grownclose.models.Affiliated;
import com.grownclose.models.Boost;
import com.grownclose.models.Product;
import com.grownclose.repositories.BoostRepository;
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
        Product product = productService.FindByIdRepo((long) boostDto.productId());

        Boost boost = boostDto.dtoToEntity(affiliated, product);

        Boost boostResponse = boostRepository.save(boost);
        BoostDto boostDtoResponse = new BoostDto(boostResponse);

        return boostDtoResponse;
    }

}
