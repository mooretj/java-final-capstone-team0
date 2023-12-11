<template>
  <body>
    <div class="container">
      <img id="taps" src="src/assets/taps.jpg" alt="">
      <div class="centered">
        <h1 id="FindYour">Find Your New Favorite Brewery</h1>
        <input type="text" id="addressEntry" name="fname" placeholder="Enter an Address, City, or Zip">
      </div>
    </div>

    <div class="pint2">
      <img id="taps" src="src/assets/pint.png" alt="">
    </div>
<div class="line2">
    <hr id="hr2A" class="hr2A">
    <hr id="hr2B" class="hr2B">
  </div>

    <h2 id="LatestReviews">Review Flight</h2>
    <div id="BeerReviews" class="BeerReviews">
      <BeerDetailsCardView/>
    </div>

    <div class="pint2">
      <img id="taps" src="src/assets/pint.png" alt="">
    </div>
<div class="line2">
    <hr id="hr2A" class="hr2A">
    <hr id="hr2B" class="hr2B">
  </div>
    <h2 id="LatestReviews">Featured Brewery</h2>


    <div id="featuredBrewery" class="featuredBrewery">
      <BreweryDetailsCardView/>
    </div>


      <div class="pint3">
        <img id="taps" src="src/assets/pint.png" alt="">
      </div>

    <hr id="hr2A" class="hr2A">
    <hr id="hr2B" class="hr2B">

    <div id="blackout" class="blackout">
    </div>

  </body>
  <!-- <div>
    <button type="button" v-on:click="$router.push({ name: 'BreweryListView' })" >Breweries</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: 0 }})" >Beers</button>
  </div> -->
</template>

<script>
import BeerDetailsCardView from './BeerDetailsCardView.vue';
import BreweryDetailsCardView from './BreweryDetailsCardView.vue';

export default {
  components: {
    BeerDetailsCardView,
    BreweryDetailsCardView
}
};
</script>

<style>

h1#FindYour {
  width: 70vw;

  font-size: 3vw;
  color: white;
  text-shadow: black 2px 2px 4px;
  z-index: 1;
}

h2 {
  margin-top: 0px;
  margin-left: 28px;
  margin-bottom: 0px;
  font-size: 28px;
  color: white;
  text-shadow: black 3px 3px 4px;
  z-index: 1;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;

}




body {
  width: 100%;
  background-image: url("src/assets/woodBG.jpg");
  background-color: black;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  box-shadow: 0 0 1000px rgba(0, 0, 0, 1) inset;
}

input#addressEntry {
width: 40vw;
  height: 2.5vw;
  font-size: 1.5vw;
  border-style: none;
  color: black;
  box-shadow: 0 0 10px rgba(0, 0, 0, 1);

}

.BeerReviews{
  width: 100%;

}

img#taps {
  width: 100%;
  height: auto;
}

img#review {
  width: 50vh;
  height: auto;
}


img#featured {
  width: 100%;
  height: auto;
}


html {

  display: flex;
  align-items: center;
  justify-content: center;
  background-color: black;
}

.container {
  display: flex;
  position: relative;
  justify-content: center;
  text-align: center;
  color: white;

}

.centered {
  
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 35%;
  transform: translate(-50%, -50%);
  left: 50%;
}


.pint1 {
  /* border-style: solid; */
  border-color: white;
  width: 25px;
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 100%;
  transform: translate(-50%, -10px);
  left: 50%;
}

.pint2 {
  /* border-style: solid; */
  border-color: white;
  width: 25px;
  display: flex;
  flex-direction: column;
  position: absolute;
  transform: translate(-13px, -10px);
  left: 50%;
}

.pint3 {
  /* border-style: solid; */
  border-color: white;
  width: 25px;
  display: flex;
  flex-direction: column;
  position: absolute;
  transform: translate(-13px, -10px);
  left: 50%;
}

#hr1A {
  width: 49%;
  transform: translate(-52%, -400%);
}

#hr1B {
  width: 49%;
  transform: translate(51.7%, -900%);
}

#hr2A {
  width: 48%;

  transform: translate(-25.65vw, -8px);
}

#hr2B {
  width: 48%;
  transform: translate(25.65vw, -18px);
}

#featuredBrewery{
  margin-top: -70px;
  height: 800px;
  background-color: gray;
}
#blackout{
  margin-top: -28px;
  height: 20px;
  background-color: black;
}


</style>