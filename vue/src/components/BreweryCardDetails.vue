<template>

   
    <div class="BreweryDetailsMain" id="overlay" :style="`background-image: url(${brewery.brewery_main_img});`">
        <div class="dim">
        <div class="name">
            <h1>{{ brewery.brewery_name }}</h1>
            <img class="brewery-img" :src="brewery.brewery_main_img" alt=""/>
        </div>

        <div class="BreweryDetails">
  
            <div class="history">
                <label>Brewery History:</label><br>
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
 
img {
    display: none;
  }
    h2 {
    color: #CA801B;
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
    justify-content: center;
    align-items: center;
    transition: .5s;
  }


  .name {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    font-size: 2vw;
    height: 25vw;
    width: 100%;
    margin: 0px;
    text-shadow: black 3px 3px 4px;
    
  }

  .BreweryDetails {
    display: none;
    height:25vh;
    
  }

    .dim:hover{
    background-color: rgba(0, 0, 0, 0.75);
    backdrop-filter: blur(8px);
  }
    .BreweryDetailsMain:hover img {
    width: 30vw;
    display: initial;
    
  }

  .BreweryDetailsMain:hover .name {
    width: 50vw;
    font-size: 1vw;
    justify-content: space-around;
   background-color: rgba(0, 0, 0, 0);
  }

  .BreweryDetailsMain:hover .BreweryDetails {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 45vw;
  }
  
  
  </style>
    