package com.grownclose.application.order.dto;

import com.grownclose.domain.orders.Order;

public record OrderFindDto(int id, float amount, int deliveryTypeId, int orderStatusId, int resellerId, int productId) {
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
