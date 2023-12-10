<template>
        <!-- <div id="hopspotter">
      <img id="hopspotter" src="src/assets/HopSpotter.png" alt="beerimage">
    </div> -->
      <div id="logo">
      <img id="logo" src="src/assets/HopSpotter.png" alt="beerimage">
    </div>
  <header>
    <div id="topnav" class="topnav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Breweries</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BeerListView', params: { breweryId: 0 } }">Beers</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">News</router-link>&nbsp;
    </div>

    <div id="topnav" class="topnav">
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login&nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
  </header>

  <div id="capstone-app">
    <router-view />
  </div>

  <footer>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Breweries</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BeerListView', params: { breweryId: 0 } }">Beers</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">News</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Best Of</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Reviews</router-link>
    </div>
  </footer>
</template>

<style>
* {
  color: white;
  viewport-fit:auto;
}

header {
  width: 100%;
  margin-top: 0px;
  
  justify-content: space-between;
  background-color: rgb(0, 0, 0);
  display: flex;
  border-style: none;
  border-color: white;
  height: 90px;
}

footer {
  margin-top: 20px;
  background-color: rgb(0, 0, 0);
  border-color: white;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
}

img#logo {
  z-index: 0;
  width: 150px;
  height: auto;
  align-items: center;
  position: absolute;
left: 50%;
translate: -83px 5px;
}

a{
  color: gainsboro;
  text-decoration: none;
}

a:hover{
color: #CA801B;
}

 div #topnav{
  margin-left: 30px;
  margin-right: 30px;
  z-index: 1;
  display: flex;
  justify-content: space-between;
  color: gray;
  align-items: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 16px;
  text-shadow: black 2px 2px 2px;


  
}



div #nav{
  display: flex;
  justify-content:center;
  align-items: flex-end;
  color: gray;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 14px;
}

input, textarea, button {
  color: black;
}




</style>
