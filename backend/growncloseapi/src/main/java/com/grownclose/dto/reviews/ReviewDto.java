package com.grownclose.dto.reviews;

import com.grownclose.models.Review;

public record ReviewDto(float vote, String content, int userId, int productId) {
}
