<template>
    <div class="text-center">
        <h1>Add a review</h1>
        <review-form v-bind:review='review'/>
    </div>
</template>
    

<script>
    import ReviewForm from '../components/ReviewForm.vue';

    export default {
        components: {
            ReviewForm
        },
        data() {
            return {
                review: {
                    reviewId: 0,
                    userId: Number(this.$store.state.user.id),
                    beerId: Number(this.$route.params.beerId),
                    title: '',
                    body: '',
                    rating: 0
                }
            }
        }
    }
</script>