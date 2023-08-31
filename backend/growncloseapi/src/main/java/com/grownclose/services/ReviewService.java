package com.grownclose.services;

import com.grownclose.dto.reviews.ReviewDto;
import com.grownclose.models.Review;
import com.grownclose.repositories.ProductRepository;
import com.grownclose.repositories.ReviewRepository;
import com.grownclose.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    private Logger logger = Logger.getLogger(ReviewService.class.getName());

    public ReviewDto save(ReviewDto reviewDto) {

        //Verify if the vote is between 0 and 5

        Review review = new Review();
        review.setVote(reviewDto.vote());
        review.setContent(reviewDto.content());
        review.setDate(LocalDateTime.now());

        review.setUser(userService.FindByIdRepo((long) reviewDto.userId()));
        review.setProduct(productService.FindByIdRepo((long) reviewDto.productId()));

        //Improve this:
        //Verify if this combination already exist
        //If it exists, call the update method

        reviewRepository.save(review);

        return reviewDto;
    }
}

