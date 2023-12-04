<template>
    <header class="flex">
      <h1>{{ beer.name }}</h1>
      <div class="actions">
        <button class="btn-edit" v-on:click="$router.push({ name: 'EditBeerView', params: {beerId: beerId} })">Edit</button>
        <button class="btn-delete" v-on:click="deleteBeer">Delete</button>
      </div>
    </header>
    <div class="Description">
      <label>Beer Description:</label>&nbsp;
      <span>{{ beerDescription }}</span>
    </div>

    <div class="BeerImage">
      <label>Beer Description:</label>&nbsp;
      <img src={{ beerImage }} alt="">
    </div>

    <div class="abv">
      <label>Beer ABV:</label>&nbsp;
      <span>{{ beerABV }}</span>
    </div>

    <div class="BeerType">
      <label>Beer Type:</label>&nbsp;
      <span>{{ beerType }}</span>
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
        if (confirm("Are you sure you want to delete this beer? This action cannot be undone."
        )
        ) {
          beerService
            .deleteBeer(this.beer.id)
            .then(response => {
              if (response.status === 200) {
                this.$store.commit(
                  'SET_NOTIFICATION',
                  {
                    message: `Beer ${this.beer.name} was successfully deleted.`,
                    type: 'success'
                  }
                );
                this.$router.push({ name: 'BeerDetailsView', params: { id: this.beer.beerId }});
              }
            })
            .catch(error => {
              if (error.response) {
                this.$store.commit('SET_NOTIFICATION',
                  `Error deleting beer. Response received was "${error.response.statusText}".`);
              } else if (error.request) {
                this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Server could not be reached.');
              } else {
                this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Request could not be created.');
              }
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

  </style>
  