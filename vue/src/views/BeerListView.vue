<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>

  <div v-else>
    <!-- <h1>Beers</h1> -->
    <beerList />

  </div>
</template>

<script>
import beerList from '../components/BeerList.vue';

export default {
  components: {
    beerList,
  },
  data() {
    return {
      beers: [],
      isLoading: true
    };
  }
}
</script>

<style></style>