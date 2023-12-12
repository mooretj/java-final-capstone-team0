<template>

<div class="form">
  <div class="text-center">
      <form v-on:submit.prevent="submitForm">

        <!-- <div class="form-input-group">
          <label for="beerId">Beer ID: </label>
          <input type="text" id="beerId" v-model="editBeer.beer_id" />
        </div>

        <div class="form-input-group">
          <label for="breweryId">Brewery ID: </label>
          <input type="text" id="breweryId" v-model="editBeer.brewery_id" />
        </div> -->

        <div class="form-input-group">
          <input type="text" id="name" v-model="editBeer.beer_name" placeholder="Beer Name"   class="textEntry" />
        </div>

        <div class="form-input-group">
          <input type="text" id="beerImage" v-model="editBeer.beer_img" placeholder="Beer Image URL"  class="textEntry" />
        </div>

        <div class="form-input-group">
          <input type="abv" id="abv" v-model="editBeer.abv" placeholder="ABV"  class="textEntry" />
        </div>

        <div class="form-input-group">
          <input type="text"  id="beerType" v-model="editBeer.beer_type" placeholder="Beer Type"  class="textEntry" />
        </div>

        <div class="form-input-group">
          <textarea rows="5" type="text" id="description" class="description" v-model="editBeer.beer_description" placeholder="Description"  />
        </div>


      </form>
    </div>
  </div>
  <div class="submitcancel">
        <button class="button" type="submit">{{ this.editBeer.beer_id == 0 || this.editBeer.beer_id == null? "Add Beer" : "Edit Beer"}}</button>
        <button class="button" type="button" v-on:click="cancelForm">Cancel</button>
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
          if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
          if (this.editBeer.beer_id == 0 ) {
            beerService
              .addBeer(this.editBeer)
              .then(response => {
                // if (response.status == 201) {
                  // this.$store.commit(
                  //   'SET_NOTIFICATION',
                  //   {
                  //     message: 'A new beer was added.',
                  //     type: 'success'
                  //   }
                  // );
                  this.$router.push({ name: 'BeerListView', params: { breweryId: this.beer.brewery_id }});
                // }
              })
              .catch(error => {
                this.handleErrorResponse(error, 'adding');
              });
          } else {
            beerService
              .updateBeer(this.editBeer)
              .then(response => {
                // if (response.status == 201) {
                  // this.$store.commit(
                  //   'SET_NOTIFICATION',
                  //   {
                  //     message: `Message ${this.editBeer.name} was updated.`,
                  //     type: 'success'
                  //   }
                  // );
                  this.$router.push({ name: 'BeerDetailsView', params: { beerId: this.editBeer.beer_id }});
                // }
              })
              .catch(error => {
                this.handleErrorResponse(error, 'updating');
              });
          }
    }
    else {
      alert("You must be authorized to do that.")
    }
  },
    cancelForm() {
      // this.$router.push({ name: "BreweryDetailsView", params: { breweryId: this.$route.params.breweryId } });
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
.form {
  
    background-color: black;
    opacity: .8;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 60vh;
}



.text {
  
    text-align: center;
    

}

.text-center{
  width: 75%;
}

.submitcancel{
    display: flex;
    align-items: center;
    justify-content: center;
}


.button{
    width: 200px;
}

.textEntry {

    margin: 3px;
    height: 28px;
    
}


.description{    
  width: 75%;
  resize: none;
  margin: 3px;
}

</style>
    