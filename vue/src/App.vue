<template>
  <div id="logo" @click='this.$router.push( { name: "home" })'>
    <img id="logo" src="/src/assets/HopSpotter.png" alt="beerimage">
  </div>
  <header>
    <div id="topnav" class="topnav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Brewery Map</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BeerListView', params: { breweryId: 0 } }">Beers</router-link>&nbsp;
    </div>

    <div id="topnav" class="topnav">
      <router-link v-bind:to="{ name: 'login' }" v-if="this.$store.state.token == ''">Login&nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'register' }" v-if="this.$store.state.token == ''">Register</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
    </div>
  </header>

  <div id="capstone-app">
    <router-view />
  </div>

  <footer>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Brewery Map</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BeerListView', params: { breweryId: 0 } }">Beers</router-link>&nbsp;
    </div>
    <div>
    <p class="aboutus">
      Tech Elevator Sep 2023 CLE Java
      <br> 
      tjmoore + joshschaeffer + ianmcgreal + justinfalasca
      <br>
      Copyright 2023 
    </p>
  </div>

  </footer>
</template>

<style>
* {
color: white;
viewport-fit:auto;
-ms-overflow-style: none;
scrollbar-width:none;
font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}



::-webkit-scrollbar {
  display: initial;
}

::-webkit-scrollbar-track {
  background: whitesmoke;
}
::-webkit-scrollbar-thumb {
  background: rgb(65,65,65);
}
::-webkit-scrollbar-thumb:hover {
  background: rgb(100,100,100);
}

header {
  width: 100%;
  justify-content: space-between;
  background-color: black;
  display: flex;
  border-style: none;
  border-color: white;
  height: 90px;
}

img#logo {
  cursor: pointer;
  z-index: 0;
  width: 160px;
  margin-top: 5px;
  height: auto;
  align-items: center;
  position: absolute;
  left: 50%;
  translate: -75px;
}



footer {
  width: 100%;
  background-color: black;
  border-color: white;
  height: 90px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}


a {
  color: gainsboro;
  text-decoration: none;
}

a:hover {
  color: #CA801B;
}

div #topnav {
  margin-left: 30px;
  margin-right: 30px;
  z-index: 1;
  display: flex;
  justify-content: space-between;
  color: gray;
  align-items: center;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 20px;
  text-shadow: black 2px 2px 2px;
}

div #nav {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  color: gray;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 20px;
  margin-top: 15px;
}

.aboutus{
  font-size: 12px;
  text-align: center;
}

input,
textarea,
button {
  color: black;
}

button {
  cursor: pointer;
    font-size: 2vh;
    background-color: rgb(46, 49, 47);
    color: #CA801B;
    border: 2px solid black;
    box-shadow: black 3px 3px 4px;
    border-radius: 8px;
    height: 5vh;
    padding: 0px 10px;
    transition: .3s;
    margin: 10px 0px;
    width: 200px;
  }

  button:hover {
    color:whitesmoke;
    border-color: #CA801B;
  }

  
</style>