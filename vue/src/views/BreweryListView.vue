<template>
  <link href='https://api.mapbox.com/mapbox-gl-js/v2.8.1/mapbox-gl.css' rel='stylesheet'>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
        <!-- <h1>Breweries</h1> -->
      <breweryList/>

      <div>
        <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F&noprof=1" width="640" height="480"></iframe>
  </div>
      <button class="btn-add" v-on:click="addBrewery">Add Brewery</button>
    </div>

</template>
  
  <script>
  import breweryList from '../components/BreweryList.vue';

//   var mapboxgl = require('mapbox-gl/dist/mapbox-gl.js');

// mapboxgl.accessToken = 'YOUR_MAPBOX_ACCESS_TOKEN';
// var map = new mapboxgl.Map({
//   container: 'span',
//   style: 'mapbox://styles/mapbox/streets-v11'
// });


  export default {
    components: {
      breweryList,
    },
    data() {
      return {
        breweries: [],
        isLoading: false
      };
    },
    methods: {
      addBrewery() {
       if(this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          this.$router.push({ name: 'AddBreweryView' })
      }
      else {
      alert("You must be authorized to do that.")
      }
    }
    }
    
  }
  </script>
  
  <style >
  iframe {
    display: block;
    margin: auto;
  }
  
  </style>