package com.grownclose.application.deliveryType.dto;

import com.grownclose.domain.deliverytypes.DeliveryType;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeliveryTypeDto(UUID id, String name, String description) {

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
