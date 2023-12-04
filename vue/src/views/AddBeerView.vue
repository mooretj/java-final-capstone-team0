<template>
    <h1>Add A New Beer</h1>
    <beer-form v-bind:beer="beer" />
  </template>
  
  <script>
  import beerForm from '../components/BeerForm.vue';
  
  export default {
    components: {
      beerForm
    },
    data() {
      return {
        beer: {
          id: 0,
          brewery_id: Number(this.$route.params.brewery_id),
          name: '',
          description: '',
          beerImage: '',
          abv: '',
          beerType:'',
        },
      }
    } 
  };
  </script>



  <style scoped>


  </style>