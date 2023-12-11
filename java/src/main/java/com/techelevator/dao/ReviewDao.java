package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    Review getReviewById(int reviewId);

    List<Review> getReviewsByBeerId(int beerId);

    Review getRandomReviewByBeerId(int beerId);

    Review createReview(Review review);

    Review getRandomReviewByBeerId(int beerId);

}
