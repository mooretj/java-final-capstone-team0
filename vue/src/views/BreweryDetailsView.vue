<template>
    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>
    <div v-else>
      <nav>
        <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      </nav>
      <brewery-details v-bind:brewery="brewery" />
    </div>
  </template>
  
  <script>
  import breweryService from '../services/BreweryService';
  import breweryDetails from '../components/BreweryDetails.vue';
  
  export default {
    components: {
      breweryDetails,
    },
    data(){
      return {
        breweryId: this.$route.params.breweryId,
        brewery: {},
        isLoading: true
      }
    },
    methods: {
      getBrewery(id) {
        breweryService.get(id)
        .then(response => {
          this.brewery = response.data;
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
            this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
          }
      }
    },
    created() {
      this.getBrewery(this.$route.params.breweryId);
    }
  };
  </script>
  
  <style scoped>
  </style>
  