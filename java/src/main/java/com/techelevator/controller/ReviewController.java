package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Path;
import javax.validation.Valid;

@RestController
@CrossOrigin
public class ReviewController {

    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "beers/{beerId}/reviews", method = RequestMethod.POST)
    public Review addReview(@Valid @RequestBody Review newReview, @PathVariable int beerId) {
        Review review = null;
        try {
            newReview.setUserId(newReview.getUserId());
            review = reviewDao.createReview(newReview);
            if (review == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Review submission failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Review submission failed.");
        }
        return review;
    }

    @RequestMapping(path = "reviews/{reviewId}", method = RequestMethod.GET)
    public Review getReviewByReviewId(@PathVariable int reviewId) {
        return reviewDao.getReviewById(reviewId);
    }

}
