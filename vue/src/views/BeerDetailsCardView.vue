<template>
    <div class="card">
    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
      <!-- <nav> -->
        <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      <!-- </nav> -->
      
      <beer-card-details v-bind:beer="beer" />
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
        beer: {},
        beerIds: {},
        isLoading: true
      }
    },
    methods: {
      getBeer(id) {
        beerService.get(id)
        .then(response => {
          this.beer = response.data;
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
      },
      getBeerIds() {
        beerService.getIds()
        .then(response => {
            this.beerIds = response.data;
            let randomInt = Math.floor(Math.random() * this.beerIds.length)
            this.getBeer(this.beerIds[randomInt]);
        })
        .catch(error => {
            this.handleErrorResponse(error);
          });
        }
    },
    created() {
        this.getBeerIds()
    }
  };
  </script>
  
  <style scoped>

  </style>
  