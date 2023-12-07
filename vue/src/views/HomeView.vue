<template>
  <body>

  <div class="container">
    <img id="taps" src="src/assets/taps.jpg" alt="">
    <div class="centered">
      <h1 id="FindYour">Find your new favorite brewery</h1>
      <input type="text" id="fname" name="fname" placeholder="Enter an Address, City, or Zip">
    </div>
    <div class="pint1">
        <img id="taps" src="src/assets/pint.png" alt="">
      </div>
  </div>

  <hr id="hr1A" class="hr1A">
  <hr id="hr1B" class="hr1B">
  <h2 id="LatestReviews">Latest Beer Reviews</h2>
  <div id="reviews" class="reviews">
    
    <div>
      <img id="review" src="src/assets/logo_resized.jpg" alt="">
    </div>

    <div>
      <img id="review" src="src/assets/logo_resized.jpg" alt="">
    </div>

    <div>
      <img id="review" src="src/assets/logo_resized.jpg" alt="">
    </div>
    <div class="pint2">
        <img id="taps" src="src/assets/pint.png" alt="">
  </div>
  </div>

  <hr id="hr2A" class="hr2A">
  <hr id="hr2B" class="hr2B">

  <h2 id="LatestReviews">Featured Brewery</h2>
  <div id="featuredBrewey">
    <img id="featured" src="src/assets/taps.jpg" alt="">


    <div class="pint3">
        <img id="taps" src="src/assets/pint.png" alt="">
  </div>

  </div>
  <hr id="hr2A" class="hr2A">
  <hr id="hr2B" class="hr2B">

</body>
<!-- <div>
    <button type="button" v-on:click="$router.push({ name: 'BreweryListView' })" >Breweries</button>
    <button type="button" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: 0 }})" >Beers</button>
  </div> -->
</template>

<script>
export default {
};
</script>

<style>
h1#FindYour{
  font-size: 3.5vw;
  color: white;
  text-shadow: black 2px 2px 5px;
    z-index:1;
}
h2{
  margin-left: 28px;
  font-size: 28px;
  color: white;
  text-shadow: black 2px 2px 5px;
    z-index:1;
}

body{

background-image: url("src/assets/woodBG.jpg");
background-repeat: no-repeat;
background-attachment: fixed;
background-position: center;
background-size: cover;
box-shadow: 0 0 500px rgba(0,0,0,1) inset;


}



img#taps{
  width: 100%;
  height: auto;
}

img#review{
  width: 50vh;
  height: auto;
}


img#featured{
  width: 100%;
  height: auto;
}


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
  top: 25%;
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
  transform: translate(-50%, -50%);
  left: 50%;
}

.pint2 {
  /* border-style: solid; */
  border-color: white;
  width: 25px;
  display: flex;
  flex-direction: column;
  position: absolute;
  transform: translate(-50%, 250px);
  left: 50%;
}

.pint3 {
  /* border-style: solid; */
  border-color: white;
  width: 25px;
  display: flex;
  flex-direction: column;
  position: absolute;
  transform: translate(-50%, -50%);
  left: 50%;
}

#hr1A {
  transform: translate(-52%, -400%);
}
#hr1B {
  transform: translate(52%, -900%);
}
#hr2A {
  transform: translate(-52%, -400%);
}
#hr2B {
  transform: translate(52%, -900%);
}



  
  .reviews{
display: flex;
justify-content: space-evenly;
  }
</style>