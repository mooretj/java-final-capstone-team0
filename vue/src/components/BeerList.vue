<template>

<div class="container">
      <img id="banner" src="/src/assets/glasses.jpg" alt="">
      <div class="centered">
        <h1 id="FindYour">Beer List</h1>
      </div>
  </div>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  
<div v-else class="lowercontainer">
  <h1 v-if="this.$route.params.breweryId == 0">Beers</h1>
  <div class='list'>
    
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beer_id } }">
        <h2>{{ beer.beer_name }}</h2>
      </router-link>
    </div>
    
  </div>
<button class="btn-add" v-on:click="addBeer" v-if='JSON.stringify(this.$store.state.user) !== "{}" && this.$store.state.user.authorities[0].name == "ROLE_ADMIN" || this.$store.state.user.brewer == true'>Add Beer</button>
  <br>
  <!-- <div v-if='this.$route.params.breweryId != 0'>
    <div class='return'>
      <button @click="this.$router.push({ name: 'BreweryDetailsView', params: {breweryId: this.$route.params.breweryId}})">Back to brewery</button>
    </div>
  </div> -->
</div>
</template>
  
<script>
import beerService from "../services/BeerService";
import BreweryService from '../services/BreweryService';
export default {
  data() {
    return {
      beers: [],
      brewery: {}
    }
  },
  methods: {
    addBeer() {
      if (this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
        this.$router.push({ name: 'AddBeerView' })
      }
      else {
        alert("You must be authorized to do that.")
      }
    },
    getBeers() {
      beerService.list(this.$route.params.breweryId)
        .then(response => {
          this.beers = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleError();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
    },
    getBrewery() {
      BreweryService.get(this.$route.params.breweryId)
      .then(response => {
        this.brewery = response.data;
      })
    }
  },
  created() {
    this.getBeers();
    this.getBrewery();
  }
};
</script>
  

  
<style scoped>
.lowercontainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.container {
  display: flex;
  position: relative;
  justify-content: center;
  text-align: center;
  color: white;
}

img#banner {
  width: 100%;
  height: auto;
}

.list {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.beer {
  text-align: center;
  justify-content: center;
  text-wrap: wrap;
  width: 25vw;
  height: 5vw;
  margin: 10px;
  border-radius: 10px;
  border: 1px solid #CA801B;
  background-color: rgba(0, 0, 0, 0.75);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
  transition: .2s;
  min-width: 25vw;
}

.beer:hover {
  border-color: whitesmoke;
  background-color: rgba(0,0,0,1);
}

h2 {
  font-size: 150%;
}
</style>