package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {

    @JsonProperty("review_id")
    private int reviewId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("beer_id")
    private int beerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonProperty("rating")
    private int rating;

    private String username;

    public Review() { }

    public Review(int reviewId, int userId, int beerId, String title, String body, int rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.beerId = beerId;
        this.title = title;
        this.body = body;
        this.rating = rating;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "Review Id=" + userId +
                ", User Id=" + userId +
                ", Beer Id=" + beerId +
                ", Title='" + title + '\'' +
                ", Body='" + body + '\'' +
                ", Rating=" + rating + "}";
    }
}
