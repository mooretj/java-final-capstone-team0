<template>
    <div class="container">
      <img id="banner" src="/src/assets/kegs.jpg" alt="">
      <div class="centered">
        <h1 id="FindYour">{{ brewery.brewery_name }}</h1>
      </div>
    </div>


  <div class="BreweryDetailsMain" id="overlay">
    <div class='top-container'>
      <div id="two" class="BreweryDetails">
        <div class="details-left">
          <div class="history">
            <img id="BreweryImage" class="BreweryImage" :src="brewery.brewery_main_img" alt="">
            <div class="history-details">
              <label>Brewery History: </label><br>
              <span>{{ brewery.history }}</span>
            </div>
          </div>
          <div class="beers">
            <BeerList />
            <!-- <button class="btn-see-beers"
              v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id } })">See
              Beers</button> -->
          </div>
          <!-- 
      <div class='return'>
        <button @click="this.$router.push({ name: 'BreweryListView' })">Back to Breweries</button>
      </div> -->
          <!-- <div class="edit" v-if="getBrewers">
          <button class="btn-edit-contact" v-on:click="editContact" >Edit Contact Info</button>
      </div> -->
        </div>
        <br>
        <div class='bottom-details'>
          <div class='contact'>
            <label class="contact-label">Contact Info:</label>

            <span class='contact-info'>{{ brewery.brewery_contact.brewery_address }}</span>

            <span class='contact-info'>{{ brewery.brewery_contact.phone }}</span>

            <span class='contact-info'>{{ brewery.brewery_contact.email }}</span>

            <a class='contact-info' :href=brewery.website target='_blank'>{{ brewery.brewery_name }} Website</a>

            <div class="edit-contact">
                <button class="btn-edit-contact" v-on:click="editContact">Edit Contact Info</button>
              </div>
          </div>
          

          <!-- <div class="details-right"> -->
          <div class="hours">
            <label class='hours-label'>Hours of Operation:</label>
            <table id="week">
              <!-- <tr>
                  <th>Day</th>
                  <th>Open</th>
                  <th>Close</th>
                </tr> -->
              <tr>
                <td class='day'>Sunday</td>
                <td>{{ sundayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.sunday_open) }}</td>
                <td>{{ sundayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.sunday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Monday</td>
                <td>{{ mondayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.monday_open) }}</td>
                <td>{{ mondayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.monday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Tuesday</td>
                <td>{{ tuesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.tuesday_open) }}</td>
                <td>{{ tuesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.tuesday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Wednesday</td>
                <td>{{ wednesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.wednesday_open) }}</td>
                <td>{{ wednesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.wednesday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Thursday</td>
                <td>{{ thursdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.thursday_open) }}</td>
                <td>{{ thursdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.thursday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Friday</td>
                <td>{{ fridayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.friday_open) }}</td>
                <td>{{ fridayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.friday_close) }}</td>
              </tr>
              <tr>
                <td class='day'>Saturday</td>
                <td>{{ saturdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.saturday_open) }}</td>
                <td>{{ saturdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.saturday_close) }}</td>
              </tr>
            </table>
            <!-- <div class='edit-actions'
              v-if='(JSON.stringify(this.$store.state.user) !== "{}" && (this.$store.state.user.authorities[0].name == "ROLE_ADMIN" || getBrewers))'> -->
              <div class='edit-actions'
              v-if="JSON.stringify(this.$store.state.user) !== '{}' && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">

              <div class="edit-hours">
                <button class="btn-edit-hours" v-on:click="editHours">Edit Hours of Operation</button>
              </div>
            </div>

          </div>


          <!-- </div> -->

          <!-- <div class="beers">
        <button class="btn-see-beers"
          v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id } })">See Beers</button>
      </div> -->


        </div>



      </div>


    </div>
  </div>
</template>
  
<script>
import breweryService from '../services/BreweryService.js';
import BeerList from '../components/BeerList.vue';
import { RouterLink } from 'vue-router';

export default {
  props: {
    brewery: { type: Object, required: false }
  },
  data() {
    return {
      sundayNull: this.brewery.brewery_hours.sunday_open == "00:00:00" && this.brewery.brewery_hours.sunday_close == "00:00:00",
      mondayNull: this.brewery.brewery_hours.monday_open == "00:00:00" && this.brewery.brewery_hours.monday_close == "00:00:00",
      tuesdayNull: this.brewery.brewery_hours.tuesday_open == "00:00:00" && this.brewery.brewery_hours.tuesday_close == "00:00:00",
      wednesdayNull: this.brewery.brewery_hours.wednesday_open == "00:00:00" && this.brewery.brewery_hours.wednesday_close == "00:00:00",
      thursdayNull: this.brewery.brewery_hours.thursday_open == "00:00:00" && this.brewery.brewery_hours.thursday_close == "00:00:00",
      fridayNull: this.brewery.brewery_hours.friday_open == "00:00:00" && this.brewery.brewery_hours.friday_close == "00:00:00",
      saturdayNull: this.brewery.brewery_hours.saturday_open == "00:00:00" && this.brewery.brewery_hours.saturday_close == "00:00:00"
    };
  },
  methods: {
    getBrewers() {
      breweryService.getBrewers(this.$route.params.breweryId)
        .then(response => {
          let brewers = response.data;
          return brewers.includes(this.$store.state.user.id);
        });
    },
    convertTime(t) {
      const hoursAsNum = Number(t.slice(0, 2));
      if (hoursAsNum == 0) {
        return "12".concat(t.slice(2, 5)).concat(" AM");
      }
      else if (hoursAsNum == 12) {
        return "12".concat(t.slice(2, 5)).concat(" PM");
      }
      else if (hoursAsNum > 12) {
        return String(hoursAsNum - 12).concat(t.slice(2, 5)).concat(" PM");
      }
      else {
        return String(hoursAsNum).concat(t.slice(2, 5)).concat(" AM");
      }
    },
    editContact() {
      if (this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
        this.$router.push({ name: 'EditContactView', params: { breweryId: this.brewery.brewery_id } });
      }
      else {
        alert("You must be authorized to edit contact information.");
      }
    },
    editHours() {
      if (this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
        this.$router.push({ name: 'EditHoursView', params: { breweryId: this.brewery.brewery_id } });
      }
      else {
        alert("You must be authorized to to edit hours of operation.");
      }
    }
  }
  // components: { RouterLink }
  ,
  components: { BeerList }
}
</script>
  
<style scoped>
.BreweryDetailsMain {
  margin-left: 12px;
  margin-right: 12px;
  display: flex;
  justify-content: center;
  height: auto;
  width: 99%;
  z-index: 10;
}

label {
  color: #CA801B;
}

.BreweryImage {
  max-height: 70vh;
  width: auto;
  margin: 2vw;
}

.effect {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 25vw;
  backdrop-filter: blur(5px);
  background-color: rgba(0, 0, 0, 0.3);
}

.brewery-container {
  background-position: center;
  background-size: cover;
  width: 100%;
  background-repeat: no-repeat;
  display: flex;
  position: relative;
  justify-content: center;
  text-align: center;
  color: white;
  align-items: center;
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

.BreweryDetails {
  width: 80%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.bottom-details {
  display: flex;
  justify-content: space-around;
  width: 100%;
}

.day {
  font-weight: bold;
}

.BreweryImage {

  display: flex;
  align-items: center;
  justify-content: start;
  width: 30vw;
  position: relative;
  padding-right: 8vw;
  border-right: 1px solid #CA801B;
  z-index: 1;
}

.top-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 98%;
}

#two {
  justify-content: center;
  display: flex;
  padding: 20px;
  background-color: rgba(0, 0, 0, .6);
  z-index: 15;
  width: 100%;

}

h1 {
  margin-bottom: 2.5vw;
  font-size: 3vw;
  text-shadow: black 3px 3px 4px;
  z-index: 1;
}


.details-left {
  width: 80%;
  margin-right: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}




.hours {
  display: flex;

  flex-direction: column;
  align-items: center;
  margin-right: 25px;
}

.hours-label {
  margin-left: 13px;
}

.contact {
  display: flex;
  flex-direction: column;
  justify-content: start;
  font-size: large;

}

.contact-label {
  margin-bottom: 7vh;
}

.contact-info {
  margin-bottom: 4vh;
}

.history {
  width: 100%;
  font-size: 18px;
  display: flex;
  justify-content: center;
  align-items: center;
}

th {
  text-align: left;
}

table {
  border-collapse: separate;
  border-spacing: 15px;
}

.container {
  width: 100%;
}

.beer {
  height: auto;
}
</style>
  