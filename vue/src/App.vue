<template>
  <header>
    <div id="nav">
      <router-link v-bind:to="{ name: 'BreweryListView' }">Breweries</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">News</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Best Of</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryListView' }">Reviews</router-link>
    </div>
    <div> 
      <img id="logo" src="src/assets/logo_resized.jpg" alt="beerimage">
    </div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
  </header>

  <div id="capstone-app">
    <router-view />
  </div>

  <footer>
    <div>test</div>
    <div>test</div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
  </footer>
</template>

<style>
* {
  color: white;
}

header{
  background-color: rgb(0, 0, 0);
  display: flex;
  align-items: flex-end;
  border-style: none;
  border-color: white;
  justify-content: space-between;
  align-items: bottom;
  height: 100px;
  
}

img#logo{
height: 70px;
align-items: center;
}

a{
  color: white;
  text-decoration: none;
}

div #nav{
  color: white;
  font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
</style>
