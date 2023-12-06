<template>
  <header class="flex">
    <h1>{{ brewery.brewery_name }}</h1>
    <!-- <div class="actions">
      
    </div> -->
  </header>

  <div class="history">
    <label>Brewery History:</label>&nbsp;
    <span>{{ brewery.history }}</span>
  </div>

  <div class="hours">
    <label>Hours:</label>&nbsp;
    <div><span>{{ brewery.open_hour }}</span> - <span>{{ brewery.close_hour }}</span></div>=   
  </div>

  <div class="beers">
      <button class="btn-see-beers" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id }})">See Beers</button>
  </div>
</template>
  
<script>
  export default {
    props: {
      brewery: { type: Object, required: false }
    }   
  }
</script>
  

  
<style>

</style>
  