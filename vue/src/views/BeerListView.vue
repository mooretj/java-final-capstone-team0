<template>
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beerId } }">
        {{ beer.name }}  
      </router-link>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      beers: {
        type: Array,
        required: true
      }
    },
  };
  </script>
  
  <style>

  </style>
  