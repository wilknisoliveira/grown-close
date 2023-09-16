package com.grownclose.application.order.dto;

import com.grownclose.domain.orders.Order;

import java.util.UUID;

public record OrderFindDto(UUID id, float amount, UUID deliveryTypeId, UUID orderStatusId, UUID resellerId, UUID productId) {
    public OrderFindDto(Order order) {
        this (
                order.getId(),
                order.getAmount(),
                order.getDeliveryType().getId(),
                order.getOrderStatus().getId(),
                order.getReseller().getId(),
                order.getProduct().getId()
        );
    }
}
