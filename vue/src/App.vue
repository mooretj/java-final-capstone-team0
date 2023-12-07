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
      <router-link v-bind:to="{ name: 'BreweryListView' }">News</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Best Of</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Reviews</router-link>
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
  color: orangered;
}

header {
  margin-left: 15px;
  margin-right: 15px;
  margin-bottom: 1px;
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
  z-index: 1;
  height: 80px;
  align-items: center;
}

a{
  color: white;
  text-decoration: none;
}

 div #topnav{
  z-index: 0;
  display: flex;
  justify-content: space-between;
  color: gainsboro;
  align-items: flex-end;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: smaller;
}

div #logo{
  display: flex;
  translate: -50;
}

div #nav{
  display: flex;
  justify-content:center;
  align-items: flex-end;
  color: white;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: smaller;
}

#logo {
  position: absolute;
left: 50%;
translate: -40px -2px;
}

#hopspotter {
  position: absolute;
translate: 5px 0px;
}

img#hopspotter {
  z-index: -1;
  height: 75px;
  align-items: center;
}



</style>
