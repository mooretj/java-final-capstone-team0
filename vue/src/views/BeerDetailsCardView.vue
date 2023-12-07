<template>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
      <!-- <nav> -->
        <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      <!-- </nav> -->
      <beer-details v-bind:beer="beer" />
    </div>

  </template>
  
  <script>
  import beerService from '../services/BeerService';
  import beerDetails from '../components/BeerDetails.vue';
  
  export default {
    components: {
      beerDetails,
    },
    data() {
      return {
        beer: {},
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
      }
    },
    created() {
      this.getBeer(this.$route.params.beerId);
    }
  };
  </script>
  
  <style scoped>
    template {
        width: 300px;
        height: 400px;
    }
  </style>
  