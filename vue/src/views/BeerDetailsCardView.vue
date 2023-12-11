<template>
  <div class="card">
    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div id="reviews" class="reviews" v-else>
      <!-- <nav> -->
      <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      <!-- </nav> -->

      <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
      <beer-card-details v-bind:beer="beer1" v-bind:review='review1' />


      <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
      <beer-card-details v-bind:beer="beer2" v-bind:review='review2' />


      <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
      <beer-card-details v-bind:beer="beer3" v-bind:review='review3' />



    </div>
  </div>
</template>
  
<script>
import beerService from '../services/BeerService';
import beerCardDetails from '../components/BeerCardDetails.vue';
import reviewService from '../services/ReviewService.js'

export default {
  components: {
    beerCardDetails,
  },
  data() {
    return {
      beer1: {},
      review1: {},
      beer2: {},
      review2: {},
      beer3: {},
      review3: {},
      beerIds: {},
      isLoading: true
    }
  },
  methods: {
    getBeer1(id) {
      beerService.get(id)
        .then(response => {
          this.beer1 = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleErrorResponse(error);
        });
    },
    getBeer2(id) {
      do {
        beerService.get(id)
          .then(response => {

            this.beer2 = response.data;

            this.isLoading = false;
          })
          .catch(error => {
            this.handleErrorResponse(error);
          });
      } while (this.beer2 == this.beer1);
    },
    getBeer3(id) {
      do {
        beerService.get(id)
          .then(response => {

            this.beer3 = response.data;

            this.isLoading = false;
          })
          .catch(error => {
            this.handleErrorResponse(error);
          });
      } while (this.beer3 == this.beer1 && this.beer3 == this.beer2);
    },
    handleErrorResponse(error) {
      if (error.response.status == 404) {
        this.$router.push({ name: 'NotFoundView' });
      } else {
        this.isLoading = false;
        // this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
      }
    },
    getReviewByBeerId1(beerId) {
      reviewService.getRandomReviewByBeerId(beerId)
        .then(response => {
          this.review1 = response.data;
        })
    },
    getReviewByBeerId2(beerId) {
      reviewService.getRandomReviewByBeerId(beerId)
        .then(response => {
          this.review2 = response.data;
        })
    },
    getReviewByBeerId3(beerId) {
      reviewService.getRandomReviewByBeerId(beerId)
        .then(response => {
          this.review3 = response.data;
        })
    },
    getBeerIds() {
      beerService.getIds()
        .then(response => {
          this.beerIds = response.data;


          this.getBeer1(this.beerIds[0]);
          this.getBeer2(this.beerIds[1]);
          this.getBeer3(this.beerIds[2]);

          this.getReviewByBeerId1(this.beerIds[0]);
          this.getReviewByBeerId2(this.beerIds[1]);
          this.getReviewByBeerId3(this.beerIds[2]);


        })
        .catch(error => {
          this.handleErrorResponse(error);
        });
    }
  },
  async created() {
    await this.getBeerIds();


  }
};
</script>
  
<style scoped>
.reviews {

  display: flex;
  justify-content: space-evenly;
}
</style>
  