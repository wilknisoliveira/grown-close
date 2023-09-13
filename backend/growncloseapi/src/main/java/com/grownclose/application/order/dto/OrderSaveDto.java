package com.grownclose.application.order.dto;

public record OrderSaveDto(int quantity, int deliveryTypeId, int resellerId, int productId) {
}
