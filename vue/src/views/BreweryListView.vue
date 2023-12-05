<template>
    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>
    <div v-else>
      <header class="flex">
        <h1>Breweries</h1>
      </header>
      <breweryList v-bind:breweries="breweries"/>
    </div>
  </template>
  
  <script>
  import breweryList from '../components/BreweryList.vue';
  
  
  export default {
    
    components: {
      breweryList,
    },
    data() {
      return {
        breweries: [],
        isLoading: false
      };
    }
    
  }
  </script>
  
  <style >
  </style>