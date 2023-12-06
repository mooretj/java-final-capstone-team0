<template>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
        <h1>Breweries</h1>
      <breweryList/>

      <div>
        <iframe src="https://www.google.com/maps/d/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F" width="640" height="480"></iframe>
  </div>
      <button class="btn-add" v-on:click="$router.push({ name: 'AddBreweryView' })">Add Brewery</button>
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