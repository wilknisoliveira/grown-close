package com.grownclose.application.review.dto;


import java.util.UUID;

public record ReviewDto(float vote, String content, UUID userId, UUID productId) {
}
