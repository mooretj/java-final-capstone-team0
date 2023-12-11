package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Review getReviewById(int reviewId) {
        Review review = null;
        String sql = "SELECT review_id, users.user_id, review.beer_id, title, body, rating, username, brewery_name " +
                "FROM review " +
                "JOIN users ON review.user_id = users.user_id " +
                "JOIN brewery_beer ON review.beer_id = brewery_beer.beer_id " +
                "JOIN brewery ON brewery_beer.brewery_id = brewery.brewery_id " +
                "WHERE review.review_id = ?";
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
    public List<Review> getReviewsByBeerId(int beerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT review_id, users.user_id, review.beer_id, title, body, rating, username, brewery_name " +
                "FROM review " +
                "JOIN users ON review.user_id = users.user_id " +
                "JOIN brewery_beer ON review.beer_id = brewery_beer.beer_id " +
                "JOIN brewery ON brewery_beer.brewery_id = brewery.brewery_id " +
                "WHERE review.beer_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
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
    public Review getRandomReviewByBeerId(int beerId) {
        Review randomReview = null;
        String sql = "SELECT review_id, users.user_id, review.beer_id, title, body, rating, username, brewery_name " +
                "FROM review JOIN users ON review.user_id = users.user_id " +
                "JOIN brewery_beer ON review.beer_id = brewery_beer.beer_id " +
                "JOIN brewery ON brewery_beer.brewery_id = brewery.brewery_id " +
                "WHERE review.beer_id = ? " +
                "ORDER BY RANDOM() LIMIT 1";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
            if (results.next()) {
                randomReview = mapRowToReview(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return randomReview;
    }

    @Override
    public Review createReview(Review review) {
        Review newReview = null;
        String insertReviewSql = "INSERT INTO review (user_id, beer_id, title, body, rating) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING review_id;";
        try {
            int newReviewId = jdbcTemplate.queryForObject(insertReviewSql, int.class, review.getUserId(), review.getBeerId(),
                    review.getTitle(), review.getBody(), review.getRating());
            newReview = getReviewById(newReviewId);
        }
        catch (CannotGetJdbcConnectionException e) {
            System.err.println("Error connecting to the database");
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            System.err.println("Data integrity violation");
            throw new DaoException("Data integrity violation", e);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred");
            throw new DaoException("An unexpected error occurred", e);}
//        }catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
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
        review.setUsername(rs.getString("username"));
        review.setBreweryName(rs.getString("brewery_name"));
        return review;
    }
}
