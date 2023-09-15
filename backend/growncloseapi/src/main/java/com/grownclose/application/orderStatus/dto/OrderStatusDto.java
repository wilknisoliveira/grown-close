package com.grownclose.application.orderStatus.dto;

import com.grownclose.domain.orderstatus.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderStatusDto(UUID id, String name, String description) {
    public OrderStatusDto(OrderStatus orderStatus) {
        this (
                orderStatus.getId(),
                orderStatus.getName(),
                orderStatus.getDescription()
        );
    }

    public OrderStatus dtoToEntity() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(this.name);
        orderStatus.setDescription(this.description);
        orderStatus.setDate(LocalDateTime.now());

        return orderStatus;
    }
}
