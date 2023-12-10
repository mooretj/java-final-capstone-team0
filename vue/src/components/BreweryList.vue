<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>

  <div v-else>
    <h1>Breweries</h1>
    <br>
    <div class="brewery" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
      <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id } }">
        <h2>{{ brewery.brewery_name }}</h2>
      </router-link>
    </div>
    <div>
      <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F&noprof=1"
        width="640" height="480"></iframe>
    </div>
  </div>
</template>
  
<script>
import breweryService from "../services/BreweryService";
export default {
  data() {
    return {
      breweries: [],
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
  },
  created() {
    this.getBreweries();
  }
};
</script>
  

  
<style scoped>

.brewery {
  text-align: center;
  max-width: 20%;
  padding-top: 40px;
  border: 1px solid gray;
  border-radius: 10px;
  background-color: rgb(36, 36, 36);
}

</style>