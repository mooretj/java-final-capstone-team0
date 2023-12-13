<template>
  <button class='add-review' @click='showHide'>Review This</button>
<div class='form'>
  
      <div class="text-center" v-show='isHidden'>
          <form v-on:submit.prevent="submitForm">
    
            <div class="form-input-group">
              <label for="reviewTitle">Review Title: </label>
              <input class='textEntry' type="text" id="reviewTitle" v-model="editReview.title" />
            </div>
    
            <div class="form-input-group">
              <label for="reviewBody">Body: </label>
              <textarea class='review' name='reviewBody' id="reviewBody" rows='10' cols='20' v-model="editReview.body" />
            </div>
    
            <div class="form-input-group">
              <label for="beerRating">Rating: </label>
              <input class='rating' type="range"  id="beerRating" name='rating' min='0' max='5' v-model="editReview.rating" />
            </div>
    
            <div class='submitcancel'>
            <button class="submit" >Add Review</button>
            <button class="cancel" type="button" v-on:click="cancelForm">Cancel</button>
            </div>
    
          </form>
        </div>
        </div>
    </template>
  
  <script>
  import reviewService from '../services/ReviewService.js';
  
  export default {
      props: {
        review: {
          type: Object,
          required: true
        },
      },
      data() {
        return {
          isHidden: false,
          editReview: {
              review_id: 0,
              user_id: this.$store.state.user.id,
              beer_id: this.$route.params.beerId,
              title: '',
              body: '',
              rating: 0
          }
        };
      },
      methods: {
        showHide() {
              this.isHidden = !this.isHidden;
          },
        submitForm() {
          // if (!this.validateForm()) {
          //   return;
          // }
          if (this.editReview.reviewId == 0 || this.editReview.reviewId == null) {
            reviewService
              .addReview(this.editReview)
              .then(response => {
                // if (response.status == 201) {
                  // this.$store.commit(
                  //   'SET_NOTIFICATION',
                  //   {
                  //     message: 'A new beer was added.',
                  //     type: 'success'
                  //   }
                  // );
                  // this.$router.push({name: "BeerDetailsView", params: {beerId: this.$route.params.beerId}});
                // }
                this.isHidden = false;
              })
              .catch(error => {
                this.handleErrorResponse(error, 'adding');
              });
          } else {
            reviewService
              .updateReview(this.editReview)
              .then(response => {
              //   if (response.status == 201) {
              //     this.$store.commit(
              //       'SET_NOTIFICATION',
              //       {
              //         message: `Message ${this.editReview.title} was updated.`,
              //         type: 'success'
              //       }
              //     );
              // this.$router.push({name: "BeerDetailsView", params: {beerId: this.$route.params.beerId}});
              //   }
              this.isHidden = false;
              })
              .catch(error => {
                this.handleErrorResponse(error, 'updating');
              });
          }
    },
    cancelForm() {
      this.isHidden = false;
      // this.$router.push({name: "BeerDetailsView", params: {beerId: this.$route.params.beerId}});
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
  
  
  
  
  <style scoped>
.form {
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: black;
  opacity: .8;
  height: 60vh;
  width: 100%;
}

.form-input-group{
  width: 100vw;
}

.textEntry {
  width: 50%;

  margin: 3px;
  height: 28px;
}

.review {
  width: 50%;

  resize: none;
  margin: 3px;
}

.button {
  width: 200px;

}

.rating {
  width: 50%;
}

.submitcancel {
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>

  