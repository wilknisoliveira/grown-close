package com.grownclose.application.order.dto;

import java.util.UUID;

public record OrderSaveDto(int quantity, UUID deliveryTypeId, UUID resellerId, UUID productId) {
}
