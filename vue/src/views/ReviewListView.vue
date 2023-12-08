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
import reviewList from '../components/ReviewList.vue';

export default {
    components: {
        reviewList,
    },
    data() {
        return {
            reviews: [],
            isLoading: false
        };
    }
}
</script>
  
<style></style>