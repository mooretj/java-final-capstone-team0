<template>
    <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Breweries</h1>
      <div class="brewery" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
      <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id } }">
        {{ brewery.brewery_name }}  
      </router-link>
        </div>
    </header>
  </div>

  </template>
  
  <script>
  import breweryService from "../services/BreweryService";
  export default {
    data() {
      return {
      breweries: []
      }
    },
    methods: {
    getBreweries() {
      breweryService.list()
        .then(response => {
          this.breweries = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleError();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get brewery data from server.`);
    },
  },
  created() {
    this.getBreweries();
  }
  };
  </script>
  

  
  <style>

  </style>