<template>
    <div class="card">
    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div id="reviews" class="reviews" v-else>
      <!-- <nav> -->
        <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      <!-- </nav> -->
      <div id="review1" class="review" v-bind="beer1">
        <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
        <beer-card-details v-model:beer="beer1" />
      </div>

      <div id="review2" class="review" >
        <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
        <beer-card-details v-model:beer="beer2" />
      </div>

      <div id="review3" class="review" >
        <!-- <img src="src/assets/logo_resized.jpg" alt=""> -->
        <beer-card-details v-model:beer="beer3" />
      </div>
      
      
      
    </div>
    </div>
  </template>
  
  <script>
  import beerService from '../services/BeerService';
  import beerCardDetails from '../components/BeerCardDetails.vue';
  
  export default {
    components: {
      beerCardDetails,
    },
    data() {
      return {
        beer1: {},
        beer2: {},
        beer3: {},
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
          do
          {
        beerService.get(id)
        .then(response => {
       
            this.beer2 = response.data;
        
          this.isLoading = false;
        })
        .catch(error => {
            this.handleErrorResponse(error);
          });
        } while(this.beer2 == this.beer1);
      },
      getBeer3(id) {
        do{
        beerService.get(id)
        .then(response => {
       
            this.beer3 = response.data;
        
          this.isLoading = false;
        })
        .catch(error => {
            this.handleErrorResponse(error);
          });
        } while(this.beer3 == this.beer1 && this.beer3 == this.beer2);
      },
      handleErrorResponse(error) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.isLoading = false;
          // this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
        }
      },
      getBeerIds() {
        beerService.getIds()
        .then(response => {
            this.beerIds = response.data;

            this.getBeer1(this.beerIds[0]);
            this.getBeer2(this.beerIds[1]);
            this.getBeer3(this.beerIds[2]);
        })
        .catch(error => {
            this.handleErrorResponse(error);
          });
        }
    },
    async created() {
        await this.getBeerIds()
    }
  };
  </script>
  
  <style scoped>
  .reviews {
      margin: -10px 2vw 0px 2vw;
      display: flex;
      justify-content: space-evenly;
  }

  .review:hover {
      transform: rotateY(180deg) scale(1.1);
      margin: -10px 1vw 30px 1vw;
      background-color: white;
      box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
  }
</style>
  