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
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'register' }">Register</router-link>&nbsp;|&nbsp;
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
}

header {

  margin-top: 0px;
  justify-content: space-between;
  background-color: rgb(0, 0, 0);
  display: flex;
  border-style: none;
  border-color: white;
  height: 90px;
}

footer {
  margin-top: -20px;
  background-color: rgb(0, 0, 0);
  border-color: white;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
}

img#logo {
  z-index: 0;
  width: 180px;
  height: auto;
  align-items: center;
  position: absolute;
left: 50%;
translate: -90px -4px;
}

a{
  color: gainsboro;
  text-decoration: none;
}

a:hover{
color: #CA801B;
}

 div #topnav{
  margin-left: 15px;
  margin-right: 15px;
  z-index: 1;
  display: flex;
  justify-content: space-between;
  color: gray;
  align-items: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 16px;
  text-shadow: black 2px 2px 2px;


  
}

div #logo{
  display: flex;
  translate: -50;
}

div #nav{
  display: flex;
  justify-content:center;
  align-items: flex-end;
  color: gray;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size:14px;
}



</style>
