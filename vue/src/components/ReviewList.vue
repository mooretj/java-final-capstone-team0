<template>
    <div class="loading" v-if="isLoading">
        <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Reviews</h1>
        <div class='review-display' v-for='review in reviews' v-bind:key='review.review_id'>
            <h2>{{ review.title }}</h2>
            <p>{{ review.body }}</p>
            <h4>- {{ review.username }}</h4>
            <div class="rating">
                <p>{{ review.rating }}/5 pints</p>
                <img src="../assets/pint.png" v-bind:title="review.rating + ' Star Review'" class="ratingStar"
                    v-for="n in review.rating" v-bind:key="n" />
            </div>
        </div>
        <reviews v-bind:reviews='reviews' />
    </div>

    <div class='return'>
        <button @click="this.$router.push({ name: 'BeerDetailsView', params: { beerId: this.$route.params.beerId } })">Back to
            Beer</button>
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
    display: flex;
    flex-direction: column;
    font-size: x-large;
    border: 1px solid gray;
    padding: 30px;
    margin: 5px 15px 5px 15px;
    border-radius: 20px;
    border: 1px solid #CA801B;
    background-color: rgba(0, 0, 0, 0.75);
    color: black;
    box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}

img {
    width: 25px;
}

h2 {
    color: #CA801B;
}
</style>