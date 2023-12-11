<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
<div v-else class="breweries">
  <h1>Breweries</h1>
  <div>
    <button class="showView" v-on:click="toggleShowList">{{ this.showList? "Show Map" : "Show List" }}</button>
    </div>
  <div class="container">
  <div v-show="showList">
    
    <br>
    <div class="brewery" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
      <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id } }">
        <h2>{{ brewery.brewery_name }}</h2>
      </router-link>
    </div>
  
  </div>
  <div class="map" v-show="!showList">
      <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F&noprof=1"
        width="640" height="480"></iframe>
    </div>
  </div>
</div>
</template>
  
<script>
import breweryService from "../services/BreweryService";
export default {
  data() {
    return {
      breweries: [],
      showList: true,
      isLoading: true
    }
  },
  methods: {
    getBreweries() {
      breweryService.list()
        .then(response => {
          this.breweries = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleError();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get brewery data from server.`);
    },
    toggleShowList() {
  this.showList = !this.showList;
 }
  },
  created() {
    this.getBreweries();
  }
};
</script>
  

  
<style scoped>
.breweries {
  width: 100vw;
  height: 100vw;
  text-align: center;
}
.container {
  display: flex;
  justify-content: space-around;
}
.brewery {
  text-align: center;
  margin: 10px;
  border-radius: 10px;
  border: 1px solid #CA801B;
  background-color: rgba(0, 0, 0, 0.75);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}

h2 {
  margin: 10px;
}
</style>