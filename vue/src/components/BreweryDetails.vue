<template>
  <div class="BreweryDetailsMain" id="overlay">

    <div class='top-container'>
      <img id="BreweryImage" class="BreweryImage" :src=brewery.brewery_main_img alt="">

      <div id="two" class="BreweryDetails">

        <div class="details-left">
          <div class="name">
            <h1>{{ brewery.brewery_name }}</h1>
          </div>

          <div class="history">
            <label>Brewery History:</label>&nbsp;
            <span>{{ brewery.history }}</span>
          </div>

          <div class="contact-info">
            <!-- <label>Contact Info</label>
        <table>
          <tr>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email Address</th>
            <th>Website</th>
          </tr>
          <tr>
            <td>{{ brewery.brewery_contact.brewery_address }}</td>
            <td>{{ brewery.brewery_contact.phone }}</td>
            <td>{{ brewery.brewery_contact.email }}</td>
            <td><a :href=brewery.website target="_blank">{{ brewery.website }}</a></td>
          </tr>
        </table> -->


          </div>
          <div class="beers">
            <button class="btn-see-beers"
              v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id } })">See
              Beers</button>
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
            <span class='contact-info'>{{ brewery.brewery_contact.brewery_address }}</span>
            <br>
            <span class='contact-info'>{{ brewery.brewery_contact.phone }}</span>
            <br>
            <span class='contact-info'>{{ brewery.brewery_contact.email }}</span>
            <br>
            <a class='contact-info' :href=brewery.website target='_blank'>{{ brewery.website }}</a>
          </div>

          <!-- <div class="details-right"> -->
            <div class="hours">
              <label>Hours of Operation</label>
              <table id="week">
                <tr>
                  <th>Day</th>
                  <th>Open</th>
                  <th>Close</th>
                </tr>
                <tr>
                  <td>Sunday</td>
                  <td>{{ sundayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.sunday_open) }}</td>
                  <td>{{ sundayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.sunday_close) }}</td>
                </tr>
                <tr>
                  <td>Monday</td>
                  <td>{{ mondayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.monday_open) }}</td>
                  <td>{{ mondayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.monday_close) }}</td>
                </tr>
                <tr>
                  <td>Tuesday</td>
                  <td>{{ tuesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.tuesday_open) }}</td>
                  <td>{{ tuesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.tuesday_close) }}</td>
                </tr>
                <tr>
                  <td>Wednesday</td>
                  <td>{{ wednesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.wednesday_open) }}</td>
                  <td>{{ wednesdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.wednesday_close) }}</td>
                </tr>
                <tr>
                  <td>Thursday</td>
                  <td>{{ thursdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.thursday_open) }}</td>
                  <td>{{ thursdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.thursday_close) }}</td>
                </tr>
                <tr>
                  <td>Friday</td>
                  <td>{{ fridayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.friday_open) }}</td>
                  <td>{{ fridayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.friday_close) }}</td>
                </tr>
                <tr>
                  <td>Saturday</td>
                  <td>{{ saturdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.saturday_open) }}</td>
                  <td>{{ saturdayNull ? "CLOSED" : this.convertTime(brewery.brewery_hours.saturday_close) }}</td>
                </tr>
              </table>
            </div>
          <!-- </div> -->

          <!-- <div class="beers">
        <button class="btn-see-beers"
          v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id } })">See Beers</button>
      </div> -->

          <div class='edit-actions'
            v-if='this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN"'>
            <div class="edit-contact">
              <button class="btn-edit-contact" v-on:click="editContact">Edit Contact Info</button>
            </div>

            <div class="edit-hours">
              <button class="btn-edit-hours" v-on:click="editHours">Edit Hours of Operation</button>
            </div>
          </div>
        </div>
        <br>



      </div>
    </div>
  </div>
</template>
  
<script>
import breweryService from '../services/BreweryService.js';
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
          return brewers.includes(this.$store.state.user.authorities[0].id);
        })
    },
    convertTime(t) {
      let hoursAsNum = Number(t.slice(0, 2));
      let formattedTime;
      if (hoursAsNum == 0) {
        formattedTime = "12".concat(t.slice(2, 5)).concat(" AM");
      }
      else if (hoursAsNum == 12) {
        formattedTime = "12".concat(t.slice(2, 5)).concat(" PM");
      }
      else if (hoursAsNum > 12) {
        formattedTime = String(hoursAsNum - 12).concat(t.slice(2, 5)).concat(" PM");
      }
      else {
        formattedTime = String(hoursAsNum).concat(t.slice(2, 5)).concat(" AM");
      }
      return formattedTime;
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
}
</script>
  
<style scoped>
.BreweryDetailsMain {
  margin-left: 12px;
  margin-right: 12px;
  display: flex;
  justify-content: center;
  height: auto;
  width: 100%;
  z-index: 10;
}

.bottom-details {
  display: flex;
  }

  .hours {
  }


.BreweryImage {
  display: flex;
  align-items: center;
  justify-content: start;
  height: 100%;
  position: relative;
  z-index: 1;
}

.top-container {
  display: flex;
  flex-direction: column;
}

#two {
  display: flex;
  flex-direction: column;
  padding: 20px;
  align-items: start;
  background-image: linear-gradient(to right, rgba(0, 0, 0, 0.3) 0%, rgba(0, 0, 0, 1) 100%);
  z-index: 15;
}

img {
  width: 900px;
  height: auto;
}

h1 {
  margin-top: 0px;
}

.details-left {
  width: 700px;
  margin-right: 20px;
}

.contact-info {

}
</style>
  