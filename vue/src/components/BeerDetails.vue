<template>
    <div class="container">
      <img id="banner" src="/src/assets/brews.jpg" alt="">
      <div class="centered">
        <h1 id="FindYour">{{ beer.beer_name }}</h1>
      </div>
  </div>
  <div class="all">
  <div class="content-centered">
  <div class="beer-content">
      <img class="beerImage" :src=beer.beer_img alt="">
    <!-- </div> -->
    <!-- <div class='beer-details'>
    <div class="beerImage">
      <img class='beer-img' :src=beer.beer_img alt="">
    </div> -->
    <div class='beer-details'>

      <div class="description">
        <label class='label'>Description:</label>
        <div class='detail'>{{ beer.beer_description }}</div>
      
      <div class="stats">
        <div class="abv inline">
          <label class='label'>ABV:&nbsp;</label>
          <div class='detail'>{{ beer.abv }}</div>
        </div>

        <div class="type inline">
          <label class='label'> Type:&nbsp;</label>
          <div class='detail'>{{ beer.beer_type }}</div>
        </div>
      </div>
    </div>
    </div>
      </div>
    </div>

    <div class='review-list'>
      <ReviewList />
    </div>
    


    <!-- <div>
      <button class='reviews' @click="$router.push({ name: 'ReviewListView', params: {beerId: beerId} })">See Reviews</button>
    </div> -->
    <div class='buttons'>
      <div class="actions"
        v-show='JSON.stringify(this.$store.state.user) !== "{}" && this.$store.state.user.authorities[0].name == "ROLE_ADMIN" || this.$store.state.user.brewer == true'>
        <button class="btn-edit" @click="editBeer">Edit</button>
        <button class="btn-delete" @click="deleteBeer">Delete</button>
      </div>

      <div class='return'>
        <button
          @click="this.$router.push({ name: 'BreweryDetailsView', params: { breweryId: this.beer.brewery_id } })">More
          From This Brewery</button>
      </div>
    </div>
  </div>
</template>
  
<script>
import beerService from '../services/BeerService.js';
import ReviewList from '../components/ReviewList.vue';

export default {
  data() {
    return {

    }
  },
  components: {
    ReviewList
  },
  props: {
    beer: { type: Object, required: true },
  },
  methods: {

    editBeer() {
      if (this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
        this.$router.push({ name: 'EditBeerView', params: { beerId: this.$route.params.beerId } })
      }
      else {
        alert("You must be authorized to do that.")
      }
    },
    deleteBeer() {
      if (this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
        if (confirm("Are you sure you want to delete this beer? This action cannot be undone.")) {
          beerService
            .deleteBeer(this.beer.beer_id)
            .then(response => {
              if (response.status === 200) {
                this.$store.commit(
                  'SET_NOTIFICATION',
                  {
                    message: `Beer ${this.beer.name} was successfully deleted.`,
                    type: 'success'
                  }
                );
                this.$router.back();
              }
            })
            .catch(error => {
              // if (error.response) {
              //   this.$store.commit('SET_NOTIFICATION',
              //     `Error deleting beer. Response received was "${error.response.statusText}".`);
              // } else if (error.request) {
              //   this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Server could not be reached.');
              // } else {
              //   this.$store.commit('SET_NOTIFICATION', 'Error deleting beer. Request could not be created.');
              // }
            });
        }
      }
      else {
        alert("You must be a authorized to do that.")
      }
    },

    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({ name: 'NotFoundView' });
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
  }
};
</script>
  

  
<style scoped>

.all {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.6);
}
  .content-centered {
    display: flex;
    justify-content: center;
    align-items: center;
    
  }

  .beer-content {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 10vh;
    margin-bottom: 10vh;
    width: 55%;
    padding: 40px;
   
  }

  .beer-details {
    display: flex;
    justify-content: space-between;
    height: 100%;
    
  }

  .beerImage {
    height: 50vh;
    padding-right: 8vw;
    border-right: 1px solid #CA801B;
  }

.inline {
  display: flex;
}

label {
  font-size: 18px;
  color: #CA801B;
}

.stats {
  margin-top: 10vh;
}

.buttons {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

  .description {
    display: flex;
    flex-direction: column;
    text-wrap: wrap;
    margin-right: 5vw;
    padding-left: 30px;
    
  }

    .container {
  display: flex;
  position: relative;
  justify-content: center;
  text-align: center;
  color: white;
}

img#banner {
  width: 100%;
  height: auto;
}

.review-list {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
  