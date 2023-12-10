<template>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
      <brewery-contact-form v-bind:brewery="brewery"/>
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
        // breweryId: this.$route.params.breweryId,
        brewery: {},
        // contact: {},
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
        }
      }
    },
    // setContact(){
    //     this.contact = this.brewery.brewery_contact;
    // },
    created() {
      this.getBreweryContact(this.$route.params.breweryId);
      this.setContact;
    }
  };
  </script>
  
  <style scoped>
  </style>