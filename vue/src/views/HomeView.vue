<template>
  <div class="home">
    <h1>Home</h1>
    <button type="button" v-on:click="$router.push({ name: 'BreweryListView' })" >Breweries</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: 0 }})" >Beers</button>
  </div>
</template>

<script>
export default {
};
</script>