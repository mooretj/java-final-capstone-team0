<template>
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beer_id } }">
        {{ beer.beer_name }}  
      </router-link>
    </div>
  </template>
  
  <script>
  import beerService from "../services/BeerService";
  export default {
    data() {
      return {
      beers: []
      }
    },
    methods: {
    getBeers() {
      beerService.list()
        .then(response => {
          this.beers = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleError();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
    }
  },
  created() {
    this.getBeers();
  }
  };
  </script>
  

  
  <style>

  </style>
  