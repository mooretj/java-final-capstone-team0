<template>
  <div class="home">
    <h1>Home</h1>
    <div>
    <button type="button" v-on:click="$router.push({ name: 'BreweryListView' })" >Breweries</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: 0 }})" >Beers</button>
  </div>
    <img src="src/assets/taps.jpg" alt="">
  </div>
</template>

<script>
export default {
};
</script>

<style>
html{
  background-color: black;
}
</style>