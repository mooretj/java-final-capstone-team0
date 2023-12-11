<template>

   
    <div class="BreweryDetailsMain" id="overlay" style="{ background-image: {{brewery.brewery_main_img}};}">
        <div class="dim">
        <div class="name">
            <h1>{{ brewery.brewery_name }}</h1>
        </div>

        <div class="BreweryDetails">
  
            <div class="history">
                <label>Brewery History:</label>&nbsp;
                <span>{{ brewery.history }}</span>
            </div>
    
            <div class="brewery link">
                <button class="btn-see-beers" v-on:click="$router.push({ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id }})">See More</button>
            </div>

        </div>
    </div>
        
    </div>

  </template>
    
  <script>
    import breweryService from '../services/BreweryService.js';
  
  export default {
      props: {
          brewery: { type: Object, required: false }
      }
  }
  </script>
    
  <style scoped>

  h1 {
    text-shadow: 1px black;
  }

  .BreweryDetails {
    display: none;
  }

  .dim:hover {
    display:initial;
    background-image: linear-gradient(to right, rgba(0,0,0,0), rgba(0,0,0,1));
  }

  .dim:hover .BreweryDetails {
    display: initial;
  }

  h2 {
    color: #CA801B;
  }
  </style>
    