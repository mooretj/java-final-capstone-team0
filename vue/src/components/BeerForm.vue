<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">
            <h1>Add A New Beer:</h1>
            <div class="form-input-group">
                <label for="name">Beer Name: </label>
                <input type="text" id="name" v-model="editBeer.name"  />
            </div>
            <div class="form-input-group">
                <label for="description">Description: </label>
                <input type="text" id="description" v-model="editBeer.description" />
            </div>
            <div class="form-input-group">
                <label for="img">Beer Image URL: </label>
                <input type="text" id="beerImage" v-model="editBeer.beerImage" />
            </div>
            <div class="form-input-group">
                <label for="abv">ABV: </label>
                <input type="abv" id="abv" v-model="editBeer.abv" />
            </div>
            <div class="form-input-group">
                <label for="beerType">Beer Type: </label>
                <input type="text"  id="beerType" v-model="editBeer.beerType" />
            </div>
            <button class="btn-submit" type="submit">Add Beer</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </form>
      </div>
    </template>
    
    <script>
    import beerService from '../services/BeerService.js';
    
    export default {
        props: {
    beer: {
      type: Object,
      required: true
    },
        },

        data() {
            return {
                editBeer: {
                    id: this.beer.id,
                    brewery_id: this.brewery_id,
                    name: this.beer.name,
                    description: this.beer.description,
                    beerImage: this.beer.beerImage,
                    abv: this.beer.abv,
                    beerType:this.beer.beerType,
                }
            };
        },
        methods: {
        submitForm() {
      if (!this.validateForm()) {
        return;
      }
      if (this.editBeer.id === 0) {
        beerService
          .addBeer(this.editBeer)
          .then(response => {
            if (response.status === 201) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: 'A new beer was added.',
                  type: 'success'
                }
              );
              this.$router.push({ name: 'BeerListDetailsView', params: { id: this.editBeer.id }});
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, 'adding');
          });
      } else {
        

        beerService
          .updateBeer(this.editBeer)
          .then(response => {
            if (response.status === 200) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: `Message ${this.editBeer.name} was updated.`,
                  type: 'success'
                }
              );
              this.$router.push({ name: 'BeerDetailsView', params: { id: this.editBeer.id }});
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, 'updating');
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
  }
}
</script>




<style>

</style>

    