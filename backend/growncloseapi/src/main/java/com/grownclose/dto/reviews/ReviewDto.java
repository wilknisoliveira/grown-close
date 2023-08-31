package com.grownclose.dto.reviews;


public record ReviewDto(float vote, String content, int userId, int productId) {
}
