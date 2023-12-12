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
          beer_id: 0,
          brewery_id: Number(this.$route.params.breweryId),
          name: '',
          description: '',
          imgUrl: '',
          abv: '',
          type:'',
        },
      }
    } 
  };
</script>



<style scoped>
h1{
    margin-top: 0px;
  margin-left: 28px;
  margin-bottom: 0px;
  font-size: 28px;
  color: white;
  text-shadow: black 3px 3px 4px;
  z-index: 1;
}

</style>