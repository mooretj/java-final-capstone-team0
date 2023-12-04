<template>
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beer_id } }">
        {{ beer.beer_name }}  
      </router-link>
    </div>
    <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Beers</h1>
      <button class="btn-add" v-on:click="$router.push({ name: 'AddBeerView' })">Add Beer</button>
    </header>
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