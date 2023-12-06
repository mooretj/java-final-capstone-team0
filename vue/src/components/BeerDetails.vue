<template>
      <h1>{{ beer.beer_name }}</h1>
    
    <div class="beerImage">
      <img :src=beer.beer_img alt="">
      <!-- <p>Here is where the image will be</p> --->
      <!-- <img src='https://cdn.shopify.com/s/files/1/0054/6682/files/how_to_make_beer_480x480.jpg?v=1682910325' alt=""> -->
      <!-- <img src='https://immigrantsonbrewing.com/wp-content/uploads/2021/05/pilsner-500x650.png' alt=""> -->
    </div>

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

    <div class="actions">
        <button class="btn-edit" v-on:click="$router.push({ name: 'EditBeerView', params: {beerId: beerId} })">Edit</button>
        <button class="btn-delete" v-on:click="deleteBeer">Delete</button>
    </div>
  </template>
  
  <script>
  import beerService from '../services/BeerService';
  export default {
    props: {
      beer: { type: Object, required: true }
    },
    computed: {

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
  

  
  <style>

  img {
    height: 200px;
  }

  </style>
  