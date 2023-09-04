package com.grownclose.dto.orderstatus;

import com.grownclose.models.OrderStatus;

import java.time.LocalDateTime;

public record OrderStatusDto(int id, String name, String description) {
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
