<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
<div v-else class="container">
  <div class='list'>
    <h1 v-if="this.$route.params.breweryId == 0">Beers</h1>
    <div class="beer" v-for="beer in beers" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'BeerDetailsView', params: { beerId: beer.beer_id } }">
        <h2>{{ beer.beer_name }}</h2>
      </router-link>
    </div>
    <button class="btn-add" v-on:click="addBeer" v-if='this.$store.state.user.authorities[0].name == "ROLE_ADMIN" || this.$store.state.user.brewer == true'>Add Beer</button>
  </div>

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
export default {
  data() {
    return {
      beers: []
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
  },
  created() {
    this.getBeers();
  }
};
</script>
  

  
<style scoped>
.container {
  display: flex;
  justify-content: center;
  width: 100vw;
}
.beer {
  text-align: center;
  margin: 10px;
  border-radius: 10px;
  border: 1px solid #CA801B;
  background-color: rgba(0, 0, 0, 0.75);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
  transition: .3s;
  min-width: 25vw;
}

.beer:hover {
  border-color: whitesmoke;
}

h2 {
  margin: 10px;
}
/* 
.list {
  display: flex;
  flex-direction: column;
  padding-left: 5vw;
  padding-right: 5vw;;
  max-width: 50vw;
  background-image: ;
} */
</style>