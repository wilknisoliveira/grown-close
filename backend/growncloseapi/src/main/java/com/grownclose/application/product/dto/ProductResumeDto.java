package com.grownclose.application.product.dto;

import java.util.UUID;

public record ProductResumeDto(UUID id, String name, float price, double salesAmount, double stars) {
}
