package com.grownclose.application.review.dto;


public record ReviewDto(float vote, String content, int userId, int productId) {
}
