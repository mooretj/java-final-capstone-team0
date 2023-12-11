<template>
  <div id="all" class="all">
    <div class="flip-card">

  <div class="flip-card-inner">
    <div class="flip-card-front">
      <div class="beerName" id="beerName">
      <h3 >BreweryName's {{ beer.beer_name }}</h3>
    </div>
      <div id="beerCardFront" class="beerCardFront" >
        <div id="container">
    <img id="reviewPic" class="reviewPic"   src="src/assets/beer4.jpg" alt="">  
  </div>
    </div>
  
      <h4>Natural perfection in a glass</h4>
      <h5>-UserName</h5>
    <h6>UserName's Rating:</h6>
    <div class="ratingPics">
<img id="ratingPic" class="ratingPic"  src="src/assets/pint.png" alt="">   
<img id="ratingPic" class="ratingPic"  src="src/assets/pint.png" alt="">   
<img id="ratingPic" class="ratingPic"  src="src/assets/pint.png" alt="">   
<img id="ratingPic" class="ratingPic"  src="src/assets/pint.png" alt="">   
<img id="ratingPic" class="ratingPic"  src="src/assets/pint.png" alt="">  
</div> 
<p>Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.
    </p>


    </div>
    <div class="flip-card-back">
      <div class="beer">
    <label>Beer ABV:</label>
    <span>{{ beer.abv }}%</span>
  </div>

  <div class="beer">
    <label>Beer Type:</label>
    <span>{{ beer.beer_type }}</span>
  </div>
  <div class="beer">
    <label>Beer Description:</label>
    <span>{{ beer.beer_description }}</span>
  </div>
    </div>
  </div>
</div>
</div>
</template>

</template>

<script>
import beerService from '../services/BeerService.js';
export default {
  props: {
    beer: { type: Object, required: true }
  },
  methods: {
    deleteBeer() {
      if (confirm("Are you sure you want to delete this beer? This action cannot be undone.")) 
      {
        beerService
          .deleteBeer(this.beer.beer_id)
          .then(response => {
            if (response.status === 200) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: `Beer ${this.beer.name} was successfully deleted.`,
                  type: 'success'
                }
              );
              this.$router.back();
            }
          })
          .catch(error => {
            // if (error.response) {
            //   this.$store.commit('SET_NOTIFICATION',
            //     `Error deleting beer. Response received was "${error.response.statusText}".`);
            // } else if (error.request) {
            //   this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Server could not be reached.');
            // } else {
            //   this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Request could not be created.');
            // }
          });
      }
    },

    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.$store.commit('SET_NOTIFICATION',
          `Error ${verb} message. Response received was "${error.response.statusText}".`);
        }
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Server could not be reached.`);
      } else {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Request could not be created.`);
      }
    },
  }
};
</script>


<style >


.container {
  display: flex;
  position: relative;
  justify-content: center;
  text-align: center;
  color: white;

}



img.reviewPic {
  width: 100%;
}
.beerName{
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  position: absolute;
  transform: translate(0px, 15px);
  left: 20px;}
img.ratingPic{
  text-align: center;

width: 30px;
}
.ratingPics{
  margin-top: -30px;

text-align: center;}

.beer {
    font-size: 18px;
    display: flex;
    flex-direction: column;
    margin: 10px 10px; 
}
label {
    font-weight: 1000;
    color: #CA801B;
    margin-bottom: 5px;
}

h3 {
  font-size: 20px;
  margin-top: -5px;
margin-left: 5px;
text-shadow: black 3px 3px 4px;

}

h4{
  font-size: 20px;
  margin-top: -5px;
  margin-left: 10px;
  font-style: italic;

  font-weight: lighter;
}
h5{
  font-size: 14px;
  margin-top: -30px;
  margin-right: 20px;
  color: rgb(200, 200, 200);
  text-align: right;
}
h6{
  font-size: 16px;
  margin-top: -20px;
  color: rgb(200, 200, 200);
text-align: center;
font-weight: lighter;
}

p{

  font-size: 12px;
  margin-left: 15px;
font-style: italic;
  font-weight: lighter;
  color: rgb(200, 200, 200);
}

.flip-card {
  
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;

    margin: 20px;
    margin-bottom: 40px;
  background-color: transparent;
  width: 400px;
  height: 600px;
  perspective: 2000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  display: flex;
  justify-content: flex-start;  
  position: relative;
  width: 100%;
  height: 100%;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
  
}

/* Position the front and back side */
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
width: 350px;
height: 350px;
border-radius: 20px;
  border: 1px solid #CA801B;
  background-color: rgba(0, 0, 0, 0.75);
  color: black;
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}

/* Style the back side */
.flip-card-back {
    width: 350px;
    height: 350px;
    border-radius: 20px;
  background-color: rgba(0, 0, 0, 0.75);
  border: 1px solid #CA801B;
  color: white;
  transform: rotateY(180deg);
  background-color: rgba(0, 0, 0, 0.7) ;

  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}
</style>
