<template>
    <div class="loading" v-if="isLoading">
        <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Reviews</h1>
        <div class='review-display' v-for='review in reviews' v-bind:key='review.review_id'>
            <h2>{{ review.title }}</h2>
            <p>{{ review.body }}</p>
        </div>
        <reviews v-bind:reviews='reviews'/>
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
    
  
    
<style scoped>
.review-display {
    border: 1px solid gray;
    padding: 30px;
    border-radius: 10px;
    margin-bottom: 5px;
    background-color: rgb(36, 36, 36);
}

</style>