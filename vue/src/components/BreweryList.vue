<template>
  <div class="brewMap">
    <div class="map">
      <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1E6x1Dagt6pIMuxneEINkxGuYs8o0vIs&ehbc=2E312F&noprof=1"
        width="600" height="600"></iframe>
    </div>
    <div class="brewlist">
      <div class="brewery-for" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
        <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: brewery.brewery_id } }">
          <div class="brewery">
            <img class="logo" :src=brewery.brewery_logo_img alt=""/>
            <h2 class="center">{{ brewery.brewery_name }}</h2>
          </div>
        </router-link>
      </div>
      
      
    </div>

    </div>
    

  <div class="addbrewery" v-if='JSON.stringify(this.$store.state.user) !== "{}" && this.$store.state.user.authorities[0].name == "ROLE_ADMIN"'>
  <button class="add-brewery" v-on:click="$router.push({ name: 'AddBreweryView' })"> Add Brewery </button>

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
  border-style: none;
  margin-bottom: 10px;
  margin-right: 15px;
}

.logo{
  width: 100px;
  height: auto;
}

iframe{
  width: 50vw;
  height: 70vh;
}

.brewlist {
  overflow-y: auto;
  display: flex;
  width: 50vw;
  height: 79vh;
  flex-wrap: wrap;
}

::-webkit-scrollbar {
  display: block;
  width: 10px;
}

::-webkit-scrollbar-track{
  background: whitesmoke;
}
::-webkit-scrollbar-thumb{
  background: rgb(65,65,65);
}
::-webkit-scrollbar-thumb:hover{
  background: rgb(100,100,100);
}

.brewery {
  cursor: pointer;
  width: 23vw;
  min-width: 300px;
  align-items: center;
  align-content: center;
  justify-items: center;
  justify-content: center;
  height: auto;
  display: flex;
  margin: 5px;
  border-radius: 10px;
  border: 1px solid #CA801B;
  background-color: rgba(46, 49, 47, 1);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
  transition: .2s;
}

.addbrewery {
  margin-top: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  max-width: 50%;
}

.brewery:hover {
  border-color: whitesmoke;
  background-color: rgba(0, 0, 0, 1);
}

h2 {
  font-size: 20px;
  margin: 10px;
  flex: 1;
}

img {
  padding-left: 1.2vw;
  padding-right: 0.5vw;
  height: 70px;
  width: 70px;
}

.map {
  margin-top: 5px;
}

</style>