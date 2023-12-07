<template>
    <div class="loading" v-if="isLoading">
        <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Reviews</h1>
        <reviewList />
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
            isLoading: true
        };
    }
}
</script>
  
<style></style>