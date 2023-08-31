package com.grownclose.controllers;

import com.grownclose.dto.reviews.ReviewDto;
import com.grownclose.services.ReviewService;
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
