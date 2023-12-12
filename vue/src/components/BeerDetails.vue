<template>
    <div class="beerImage">
      <img :src=beer.beer_img alt="">
    </div>

      <h1>{{ beer.beer_name }}</h1>

    <div class="description">
      <label>Beer Description:</label>&nbsp;
      <span>{{ beer.beer_description }}</span>
    </div>

    <div class="abv">
      <label>Beer ABV:</label>&nbsp;
      <span>{{ beer.abv }}</span>
    </div>

    <div class="type">
      <label>Beer Type:</label>&nbsp;
      <span>{{ beer.beer_type }}</span>
    </div>

    <div class='review-actions'>
      <button class='add-review' @click="$router.push({ name: 'AddReviewView', params: {beerId: beerId} })">Review This</button>
      </div>
      <div>
      <button class='reviews' @click="$router.push({ name: 'ReviewListView', params: {beerId: beerId} })">See Reviews</button>
    </div>

    <div class="actions" v-if='this.$store.state.user.authorities[0].name == "ROLE_ADMIN" || this.$store.state.user.brewer == true'>
      <button class="btn-edit" @click="editBeer">Edit</button>
      <button class="btn-delete" @click="deleteBeer">Delete</button>
    </div>

    <div class='return'>
      <button @click="this.$router.push({ name: 'BeerListView', params: {breweryId: this.beer.brewery_id} })">More From This Brewery</button>
    </div>

  </template>
  
  <script>
  import beerService from '../services/BeerService.js';
  export default {
    props: {
      beer: { type: Object, required: true }
    },
    computed: {

    },
    methods: {
      editBeer() {
        if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          this.$router.push({ name: 'EditBeerView', params: {beerId: this.$route.params.beerId} })
        }
        else {
          alert("You must be authorized to do that.")
        }
      },
      deleteBeer() {
        if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
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
      }
      else {
        alert("You must be a authorized to do that.")
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
  /* button{
    margin: 20px;
    color: black;
  } */

img {
      max-height: 300px;
    }

  </style>
  