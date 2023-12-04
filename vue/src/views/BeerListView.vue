<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Beers</h1>
      <button class="btn-add" v-on:click="$router.push({ name: 'AddBeerView' })">Add Beer</button>
    </header>
    <beerList v-bind:beers="beers"/>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js';
import beerList from '../components/BeerList.vue';


export default {
  
  components: {
    beerList,
  },
  data() {
    return {
      beers: [],
      isLoading: true
    };
  }
  
}
</script>

<style >
</style>