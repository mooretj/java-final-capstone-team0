<template>

  <div class="BreweryDetails">

    <div id="one" class="BreweryDetails">   

      <div id="BreweryImage" class="BreweryImage">
        <img id="BreweryImage" class="BreweryImage" :src=brewery.brewery_main_img alt="">
      </div>

    </div>

    <div id="two" class="BreweryDetails">

      <div class="name">
        <h1>{{ brewery.brewery_name }}</h1>
      </div>

      <div class="history">
        <label>Brewery History:</label>&nbsp;
        <span>{{ brewery.history }}</span>
      </div>

      <div class="contact-info">
        <label>Contact Info</label>
        <table>
          <tr>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email Address</th>
          </tr>
          <tr>
            <td>{{ brewery.brewery_contact.brewery_address }}</td>
            <td>{{ brewery.brewery_contact.phone }}</td>
            <td>{{ brewery.brewery_contact.email }}</td>
          </tr>
        </table>
      </div>

      <div class="hours-info">
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

      <div class="beers">
          <button class="btn-see-beers" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id }})">See Beers</button>
      </div>

      <div class="edit-contact">
          <button class="btn-edit-contact" v-on:click="editContact">Edit Contact Info</button>
      </div>

      <div class="edit-hours">
          <button class="btn-edit-hours" v-on:click="editHours">Edit Hours of Operation</button>
      </div>

    </div>
  </div>
</template>
  
<script>
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
      }
    },
    methods: {
      convertTime(t) {
        let hoursAsNum = Number(t.slice(0,2));
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
        if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          this.$router.push({ name: 'EditContactView', params: { breweryId: this.brewery.brewery_id }})
        }
        else {
          alert("You must be authorized to edit contact information.")
        }
      },
      editHours() {
        if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          this.$router.push({ name: 'EditHoursView', params: { breweryId: this.brewery.brewery_id }})
        }
        else {
          alert("You must be authorized to to edit hours of operation.")
        }
      },
    }   
  }
</script>
  
<style>

.BreweryDetails{
  margin-left: 12px;
  margin-right: 12px;
  display: grid;
  grid-template-columns: 50% 50%;
  grid-template-rows: 600px;
  border-color: white;
  border-style: solid;
}

.BreweryImage{
  display: flex;
  align-items: center;
  justify-content: start;
  height: 100%;

}

#two {
 display: flex;
 flex-direction: column;
}

</style>
  