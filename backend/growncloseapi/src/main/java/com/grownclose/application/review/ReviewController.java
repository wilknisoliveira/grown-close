package com.grownclose.application.review;

import com.grownclose.application.review.dto.ReviewDto;
import com.grownclose.domain.reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return reviewService.save(reviewDto);
    }
}
