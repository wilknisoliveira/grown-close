package com.grownclose.application.boost.dto;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.boosts.Boost;
import com.grownclose.domain.products.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record BoostDto(UUID id, int clickNumber, float balance, UUID affiliatedId, UUID productId) {
    public BoostDto(Boost boost) {
        this (
                boost.getId(),
                boost.getClickNumber(),
                boost.getBalance(),
                boost.getAffiliated().getId(),
                boost.getProduct().getId()
        );
    }

    public Boost dtoToEntity(Affiliated affiliated, Product product) {
        Boost boost = new Boost();
        boost.setDate(LocalDateTime.now());
        boost.setAffiliated(affiliated);
        boost.setProduct(product);

        return boost;
    }
}
