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
        <brewery-card-details v-model:brewery="brewery"/>
   

    </div>
    </div>
  </template>
  
  <script>
  import breweryService from '../services/BreweryService';
  import breweryCardDetails from '../components/BreweryCardDetails.vue';
  
  export default {
    components: {
      breweryCardDetails,
    },
    data() {
      return {
        brewery: {},
        isLoading: true
      }
    },
    methods: {
      getRandomBrewery() {
        breweryService.getRandomBrewery()
        .then(response => {
          this.beer1 = response.data;
          this.isLoading = false;
        })
        .catch(error => {
            this.handleErrorResponse(error);
          });
      },
      handleErrorResponse(error) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.isLoading = false;
          // this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
        }
      }
    },
    created() {
        this.getRandomBrewery();
    }
  };
  </script>
  
  <style scoped>
  .reviews {
      
      display: flex;
      justify-content: space-evenly;
  }

</style>
  