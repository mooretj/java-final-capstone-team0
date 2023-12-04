<template>
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beer_id } }">
        {{ beer.beer_name }}  
      </router-link>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      beers: {
        type: Array,
        required: false
      }
    },
  };
  </script>
  

  
  <style>

  </style>
  