<template>
  <div class="brewMap">
    <div class="map">
      <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F&noprof=1"
        width="600" height="600"></iframe>
    </div>
    <div class="brewlist">
    <div class="brewery" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
      <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id } }">
        <h2>{{ brewery.brewery_name }}</h2>
      </router-link>
      
    </div>

    </div>
    

  </div>
  <div class="addbrewery">
  <div class="brewery" v-on:click="$router.push({ name: 'AddBreweryView' })">
    <h2> Add Brewery </h2>
  </div>
</div>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
<div v-else class="breweries">

  <div class="container">
  <div v-show="showList">
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


.brewMap{
  display: flex;
  justify-content: start;
  height: 70vh;
  border-style: none;
}
iframe{
  width: 50vw;
  height: 70vh;
}

.brewlist{
  align-items: stretch;
  display: flex;
  justify-content:start;
  flex-direction: column;
  width: 25vw;
  flex-wrap: wrap;
}

.brewery {
  cursor: pointer;
  width: 24vw;
  align-items: center;
  align-content: center;
  justify-items: center;
  justify-content: center;
  height: 10vh;
  display: flex;
  margin: 5px;
  border-radius: 10px;
  border: 1px solid #CA801B;
  background-color: rgba(0, 0, 0, 0.75);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}
.addbrewery {
  margin-top: 10px;
display: flex;
align-items: center;
justify-content: center;
}


h2 {
  font-size: 2vh;
  margin: 10px;
}

.map {
  margin-top: 28px;
}
</style>