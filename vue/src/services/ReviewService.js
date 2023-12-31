import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    listBeerReviews(beerId) {
        return http.get(`beers/${beerId}/reviews`);
    },

    addReview(review) {
        return http.post(`beers/${review.beer_id}/reviews`, review);
    },

    getRandomReviewByBeerId(beerId) {
        return http.get(`reviews/random/${beerId}`)
    }

}