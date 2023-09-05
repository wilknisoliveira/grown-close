package com.grownclose.dto.boosts;

import com.grownclose.models.Affiliated;
import com.grownclose.models.Boost;
import com.grownclose.models.Product;

import java.time.LocalDateTime;

public record BoostDto(int id, int clickNumber, float balance, int affiliatedId, int productId) {
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
