package com.grownclose.dto.deliverytypes;

import com.grownclose.models.DeliveryType;

import java.time.LocalDateTime;

public record DeliveryTypeDto(int id, String name, String description) {

    public DeliveryTypeDto(DeliveryType deliveryType) {
        this (
             deliveryType.getId(),
             deliveryType.getName(),
             deliveryType.getDescription()
        );
    }

    public DeliveryType dtoToEntity() {
        DeliveryType deliveryType = new DeliveryType();

        deliveryType.setName(this.name);
        deliveryType.setDescription(this.description);
        deliveryType.setDate(LocalDateTime.now());

        return deliveryType;
    }
}
