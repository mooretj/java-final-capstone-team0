package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getReviews() {
        List<Review> reviews = null;
        String sql = "SELECT * FROM review";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Review review = mapRowToReview(results);
                reviews.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reviews;
    }

    @Override
    public Review getReviewById(int reviewId) {
        Review review = null;
        String sql = "SELECT * FROM review WHERE review_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
            if (results.next()) {
                review = mapRowToReview(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return review;
    }

    @Override
    public Review createReview(Review review) {
        Review newReview = null;
        String insertReviewSql = "INSERT INTO review (review_id, user_id, beer_id, title, body, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING review_id;";
        try {
            int newReviewId = jdbcTemplate.queryForObject(insertReviewSql, int.class,
                    review.getReviewId(), review.getUserId(), review.getBeerId(),
                    review.getTitle(), review.getBody(), review.getRating());
            newReview = getReviewById(newReviewId);
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newReview;
    }

    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setUserId(rs.getInt("user_id"));
        review.setBeerId(rs.getInt("beer_id"));
        review.setTitle(rs.getString("title"));
        review.setBody(rs.getString("body"));
        review.setRating(rs.getInt("rating"));
        return review;
    }
}
