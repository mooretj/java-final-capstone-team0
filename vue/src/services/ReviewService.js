import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    addReview(review) {
        return http.post(`beers/${review.beer_id}/reviews`, review);
    },

    getReviewById(reviewId) {
        return http.get(`reviews/${reviewId}`);
    }

}