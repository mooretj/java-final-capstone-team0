<template>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
      <nav>
        <!-- <router-link v-bind:to="{ name: 'BreweryDetailsView', params: { breweryId: breweryId } }">Back to Brewery Details</router-link> -->
      </nav>
      <brewery-contact-form v-bind:contact="contact" v-bind:breweryId="brewery.breweryId"/>
    </div>

</template>
  
  <script>
  import breweryService from '../services/BreweryService';
  import BreweryContactForm from '../components/BreweryContactForm.vue';
  
  export default {
    components: {
      BreweryContactForm,
    },
    data() {
      return {
        breweryId: this.$route.params.breweryId,
        brewery: {},
        contact: {},
        isLoading: true
      }
    },
    methods: {
      getBreweryContact(id) {
        breweryService.get(id)
        .then(response => {
          this.brewery = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleErrorResponse(error);
        });
      },
      handleErrorResponse(error) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.isLoading = false;
          this.$store.commit('SET_NOTIFICATION', `Could not get beer data from server.`);
        }
      }
    },
    setContact(){
        this.contact = this.brewery.brewery_contact;
    },
    created() {
      this.getBreweryContact(this.$route.params.breweryId);
      this.setContact;
    }
  };
  </script>
  
  <style scoped>
  </style>
  