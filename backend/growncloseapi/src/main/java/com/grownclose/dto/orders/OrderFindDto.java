package com.grownclose.dto.orders;

import com.grownclose.models.Order;

public record OrderFindDto(int id, float amount, String deliveryTypes, String status, int resellerId, int productId) {
    public OrderFindDto(Order order) {
        this (
                order.getId(),
                order.getAmount(),
                order.getDeliveryTypes(),
                order.getStatus(),
                order.getReseller().getId(),
                order.getProduct().getId()
        );
    }
}
