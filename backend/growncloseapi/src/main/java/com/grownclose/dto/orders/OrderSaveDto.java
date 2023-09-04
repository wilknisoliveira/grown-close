package com.grownclose.dto.orders;

import com.grownclose.models.Product;
import com.grownclose.models.Reseller;

public record OrderSaveDto(int quantity, int deliveryTypeId, int resellerId, int productId) {
}
