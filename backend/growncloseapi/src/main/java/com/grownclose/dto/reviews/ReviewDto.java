package com.grownclose.dto.reviews;

import com.grownclose.models.Review;

public record ReviewDto(float vote, int userId, int productId) {
}
