<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <h1>Edit Beer</h1>
    <beer-form v-bind:beer="beer" />
  </div>
    </template>
    
    <script>

    import beerService from '../services/BeerService.js'
    import beerForm from '../components/BeerForm.vue';

    
    export default {
      components:{
        beerForm
      },
        data() {
            return {
                beer: {},
                isLoading: true
            }
        },
        methods: {
    getBeer(id) {
      beerService.get(id)
        .then(response => {
          this.beer = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response) {
            if (error.response.status == 404) {
              this.$router.push({name: 'NotFoundView'});
            } else {
              this.$store.commit('SET_NOTIFICATION',
              `Error getting beer. Response received was "${error.response.statusText}".`);
            }
          } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION', `Error getting beer. Server could not be reached.`);
          } else {
            this.$store.commit('SET_NOTIFICATION', `Error getting beer. Request could not be created.`);
          }
        })
    }
  },
  created() {
    this.getBeer(this.$route.params.beerId);
  } 
};
</script>

<style scoped>
</style>









<!-- 


        methods: {
            addBeer() {
                beerService
                .add(this.beer)
                .then((response) => {
                    if (response.status === 201) {
                        this.$router.push({ name: 'HomeView' });
                    }
                });
            }
        },

        cancelForm() {
      this.$router.back();
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

    validateForm() {
      let msg = '';

      this.editBeer.name = this.editBeer.name.trim();
      if (this.editBeer.name.length === 0) {
        msg += 'The new beer must have a name. ';
      }

      this.editBeer.description = this.editBeer.description.trim();
      if (this.editBeer.description.length === 0) {
        msg += 'The beer must contain a description.';
      }

      this.editBeer.beerImage = this.editBeer.beerImage.trim();
      if (this.editBeer.beerImage.length === 0) {
        msg += 'The beer must contain an image URL.';
      }

      this.editBeer.abv = this.editBeer.abv.trim();
      if (this.editBeer.abv.length === 0) {
        msg += 'The beer must contain an ABV.';
      }

      this.editBeer.beerType = this.editBeer.beerType.trim();
      if (this.editBeer.beerType.length === 0) {
        msg += 'The beer must contain its beer type.';
      }

      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    },
  };
    </script>
    
     -->