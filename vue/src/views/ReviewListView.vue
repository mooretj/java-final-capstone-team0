<template>
    <div class="loading" v-if="isLoading">
        <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Reviews</h1>
        <reviewList v-bind:reviews='reviews'/>
    </div>
</template>
  
<script>
import reviewService from "../services/ReviewService";
import reviewList from "../components/ReviewList.vue"
export default {
    components: {
        reviewList
    },
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