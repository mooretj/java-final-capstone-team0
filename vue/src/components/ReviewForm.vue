<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">
  
          <div class="form-input-group">
            <label for="reviewTitle">Review Title: </label>
            <input type="text" id="reviewTitle" v-model="editReview.title" />
          </div>
  
          <div class="form-input-group">
            <label for="reviewBody">Body: </label>
            <textarea name='reviewBody' id="reviewBody" rows='10' cols='20' v-model="editReview.body" />
          </div>
  
          <div class="form-input-group">
            <label for="beerRating">Rating: </label>
            <input type="range"  id="beerRating" name='rating' min='0' max='5' v-model="editReview.rating" />
          </div>
  
          <button class="btn-submit" type="submit">Add Review</button>
          <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
  
        </form>
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
        editReview: {
            review_id: this.review.review_id,
            user_id: this.review.user_id,
            beer_id: this.review.beer_id,
            title: this.review.title,
            body: this.review.body,
            rating: this.review.rating
        }
      };
    },
    methods: {
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
                this.$router.push({ name: "BeerDetailsView", params: { beerId: this.review.beer_id}});
              // }
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
                this.$router.push({ name: "BeerDetailsView", params: {beerId: this.review.beer_id}});
            //   }
            })
            .catch(error => {
              this.handleErrorResponse(error, 'updating');
            });
        }
  },
  cancelForm() {
    this.$router.push({name: "BeerDetailsView", params: {beerId: this.review.beer_id}});
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

</style>