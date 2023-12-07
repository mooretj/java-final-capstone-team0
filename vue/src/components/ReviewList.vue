<template>
    <div class="loading" v-if="isLoading">
        <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Reviews</h1>
        <div class="review" v-for="review in reviews" v-bind:key="review.review_id">
            <div class='review-title'>
                <label>Review Title</label>
                <h1>{{ this.review.title }}</h1>
            </div>
            <div class='review-body'>
                <label>Review Body</label>
                <p>{{ this.review.body }}</p>
            </div>
            <div class='rating'>
                <label>Rating</label>
                <h2>{{ this.review.rating }}</h2>
            </div>
        </div>

    </div>
</template>
    
<script>
import reviewService from "../services/ReviewService";
export default {
    data() {
        return {
            reviews: []
        }
    },
    methods: {
        getReviews() {
            reviewService.listBeerReviews(this.$route.params.beerId)
                .then(response => {
                    this.reviews = response.data;
                    this.isLoading = false;
                })
                .catch(error => {
                    this.handleError();
                })
        },
        handleErrorResponse() {
          this.isLoading = false;
          this.$store.commit('SET_NOTIFICATION', `Could not get review data from server.`);
        },
    },
    created() {
        this.getReviews();
    }
};
</script>
    
  
    
<style></style>