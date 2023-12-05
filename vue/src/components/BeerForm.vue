<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">
          <div class="form-input-group">
                <label for="beerId">Beer ID: </label>
                <input type="text" id="beerId" v-model="editBeer.beer_id" />
            </div>
          <div class="form-input-group">
                <label for="breweryId">Brewery ID: </label>
                <input type="text" id="breweryId" v-model="editBeer.brewery_id" />
            </div>
            <div class="form-input-group">
                <label for="name">Beer Name: </label>
                <input type="text" id="name" v-model="editBeer.beer_name"  />
            </div>
            <div class="form-input-group">
                <label for="description">Description: </label>
                <input type="text" id="description" v-model="editBeer.beer_description" />
            </div>
            <div class="form-input-group">
                <label for="img">Beer Image URL: </label>
                <input type="text" id="beerImage" v-model="editBeer.beer_img" />
            </div>
            <div class="form-input-group">
                <label for="abv">ABV: </label>
                <input type="abv" id="abv" v-model="editBeer.abv" />
            </div>
            <div class="form-input-group">
                <label for="beerType">Beer Type: </label>
                <input type="text"  id="beerType" v-model="editBeer.beer_type" />
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
      required: false
    },
        },

        data() {
            return {
                editBeer: {
                    beer_id: this.beer.beer_id,
                    brewery_id: this.beer.brewery_id,
                    beer_name: this.beer.beer_name,
                    beer_description: this.beer.beer_description,
                    beer_img: this.beer.beer_img,
                    abv: this.beer.abv,
                    beer_type: this.beer.beer_type,
                }
            };
        },
        methods: {
        submitForm() {
      // if (!this.validateForm()) {
      //   return;
      // }
      if (this.editBeer.beer_id == 0) {
        beerService
          .addBeer(this.editBeer)
          .then(response => {
            if (response.status == 201) {
              // this.$store.commit(
              //   'SET_NOTIFICATION',
              //   {
              //     message: 'A new beer was added.',
              //     type: 'success'
              //   }
              // );
              this.$router.push({ name: 'BeerListView'});
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, 'adding');
          });
      } else {
        

        beerService
          .updateBeer(this.editBeer)
          .then(response => {
            if (response.status == 200) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: `Message ${this.editBeer.name} was updated.`,
                  type: 'success'
                }
              );
              this.$router.push({ name: 'BeerDetailsView', params: { beer_id: this.editBeer.beer_id }});
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, 'updating');
          });
      }
    },
    cancelForm() {
      this.$router.push({name: "BeerDetailsView"});
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
      // let msg = '';

      // this.editBeer.beer_name = this.editBeer.beer_name.trim();
      // if (this.editBeer.beer_name.length === 0) {
      //   msg += 'The new beer must have a name. ';
      // }
      // this.editBeer.beer_description = this.editBeer.beer_description.trim();
      // if (this.editBeer.beer_description.length === 0) {
      //   msg += 'The beer must contain a description.';
      // }
      // this.editBeer.beer_img = this.editBeer.beer_img.trim();
      // if (this.editBeer.beer_img.length === 0) {
      //   msg += 'The beer must contain an image URL.';
      // }
      // this.editBeer.beer_abv = this.editBeer.beer_abv.trim();
      // if (this.editBeer.beer_abv.length === 0) {
      //   msg += 'The beer must contain an ABV.';
      // }
      // this.editBeer.beer_type = this.editBeer.beer_type.trim();
      // if (this.editBeer.beer_type.length === 0) {
      //   msg += 'The beer must contain its beer type.';
      // }
      // if (msg.length > 0) {
      //   this.$store.commit('SET_NOTIFICATION', msg);
      //   return false;
      // }
      // return true;
    },
  }
}
</script>




<style>

</style>

    