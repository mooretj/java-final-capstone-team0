<template>
    <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <h1 >{{ beer.beer_name }}</h1>
  
  <div >
    <img :src=beer.beer_img alt="">
  </div>
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



<style scoped>
img {
    width:200px;
}
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

.flip-card {
    margin: 20px;
    margin-bottom: 40px;
  background-color: transparent;
  width: 350px;
  height: 350px;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
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
  box-shadow: 8px 8px 10px rgba(0, 0, 0, 1);
}
</style>
