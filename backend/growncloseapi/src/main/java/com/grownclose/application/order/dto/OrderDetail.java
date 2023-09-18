package com.grownclose.application.order.dto;

import java.util.UUID;

public record OrderDetail(
        UUID id,
        float amount,
        String deliveryType,
        String orderStatus,
        String productName,
        UUID productId
    ) {
}
