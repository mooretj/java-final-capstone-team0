<template>
  <div class="home">
    <h1>Home</h1>
    <button type="button" v-on:click="$router.push({ name: 'AddBreweryView' })" >Add Brewery</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView' })" >Beers</button>
  </div>
</template>

<script>
export default {
};
</script>