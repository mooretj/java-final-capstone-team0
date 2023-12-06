<template>
  <body>

  <div class="container">
    <img id="taps" src="src/assets/taps.jpg" alt="">
    <div class="centered">
      <h1>Find your new favorite brewery</h1>
      <input type="text" id="fname" name="fname" placeholder="Enter an address, neighborhood, city or ZIP code">
      <div></div>
    </div>
  </div>
  <div>
    <button type="button" v-on:click="$router.push({ name: 'BreweryListView' })" >Breweries</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: 0 }})" >Beers</button>
  </div>
</body>
</template>

<script>
export default {
};
</script>

<style>
h1{
  color: white;
  text-shadow: black 2px 2px 5px;
    z-index:1;
}
img#taps{
  width: 100%;
  height: auto;}
html{
  display: flex;
justify-content: center;
  background-color: black;
}

.container {
  display: flex;
  position: relative;
  text-align: center;
  color: white;

}

.centered {
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 40%;
  transform: translate(-50%, -50%);
  left: 50%;
}
</style>