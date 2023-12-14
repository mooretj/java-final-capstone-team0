<template>

    <div class="BreweryDetailsMain" id="overlay" :style="`background-image: url(${brewery.brewery_main_img});`">
        <div class="dim">
            <div class="featuredBrewery">
        <div class="name">
            <h1 class="brewery-name">{{ brewery.brewery_name }}</h1>
            <img class="brewery-img" :src="brewery.brewery_main_img" alt=""/>
        </div>

        <div class="BreweryDetails">
  
            <div class="history">
                <label>About us:</label><br>
                <span>{{ brewery.history }}</span>
            </div>
    
            <div class="brewery link">
                <button class="btn-see-beers" v-on:click="$router.push({ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id }})">See More</button>
            </div>
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
 
img {
    display: none;
  }
    label {
    color: #CA801B;
  }
  .name h1 {
    font-size: 4vw;
  }
  .BreweryDetailsMain {
    background-position: center;
    background-size: cover;
    width: 100vw;
    height: 85vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-repeat: no-repeat;
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  }
  .dim {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    transition: .5s;
  }


  .name {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 25vw;
    width: 100%;
    margin: 0px;
    text-shadow: black 3px 3px 4px;

  }

  .BreweryDetails {
    display: none;
    height:25vh;
    z-index: 10;
    font-size: 1.25vw;
  }

    .dim:hover{
    background-color: rgba(0, 0, 0, 0.75);
    backdrop-filter: blur(8px);
  }

  .BreweryDetailsMain:hover .brewery-name {
    font-size: 2vw;
  }
    .BreweryDetailsMain:hover img {
    width: 80vh;
    display: flex;
    
  }

  .BreweryDetailsMain:hover .name {
    width: 50vw;
    font-size: 2vw;
    justify-content: center;
   background-color: rgba(0, 0, 0, 0);
  }

  .BreweryDetailsMain:hover .BreweryDetails {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 45vw;
  }
  
  .featuredBrewery {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  
  </style>
    