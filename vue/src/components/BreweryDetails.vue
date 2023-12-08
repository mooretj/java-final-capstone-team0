<template>
    <h1>{{ brewery.brewery_name }}</h1>
    <!-- <div class="actions">
      
    </div> -->
    
    <div class="BreweryImage">
      <img :src=brewery.brewery_main_img alt="">
    </div>

    <div class="history">
      <label>Brewery History:</label>&nbsp;
      <span>{{ brewery.history }}</span>
    </div>

    <!-- <div class="hours">
      <label>Hours of Operation</label>&nbsp;
      <div class="week">
        <div>
          Sunday: {{ this.convertTime(brewery.brewery_hours.sunday_open) }} - {{ this.convertTime(brewery.brewery_hours.sunday_close) }}
        </div>
        <div>
          Monday: {{ this.convertTime(brewery.brewery_hours.monday_open) }} - {{ this.convertTime(brewery.brewery_hours.monday_close) }}
        </div>
        <div>
          Tuesday: {{ this.convertTime(brewery.brewery_hours.tuesday_open) }} - {{ this.convertTime(brewery.brewery_hours.tuesday_close) }}
        </div>
        <div>
          Wednesday: {{ this.convertTime(brewery.brewery_hours.wednesday_open) }} - {{ this.convertTime(brewery.brewery_hours.wednesday_close) }}
        </div>
        <div>
          Thursday: {{ this.convertTime(brewery.brewery_hours.thursday_open) }} - {{ this.convertTime(brewery.brewery_hours.thursday_close) }}
        </div>
        <div>
          Friday: {{ this.convertTime(brewery.brewery_hours.friday_open) }} - {{ this.convertTime(brewery.brewery_hours.friday_close) }}
        </div>
        <div>
          Saturday: {{ this.convertTime(brewery.brewery_hours.saturday_open) }} - {{ this.convertTime(brewery.brewery_hours.saturday_close) }}
        </div>
      </div>
    </div> -->
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
          <td>{{ this.convertTime(brewery.brewery_hours.sunday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.sunday_close) }}</td>
        </tr>
        <tr>
          <td>Monday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.monday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.monday_close) }}</td>
        </tr>
        <tr>
          <td>Tuesday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.tuesday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.tuesday_close) }}</td>
        </tr>
        <tr>
          <td>Wednesday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.wednesday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.wednesday_close) }}</td>
        </tr>
        <tr>
          <td>Thursday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.thursday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.thursday_close) }}</td>
        </tr>
        <tr>
          <td>Friday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.friday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.friday_close) }}</td>
        </tr>
        <tr>
          <td>Saturday</td>
          <td>{{ this.convertTime(brewery.brewery_hours.saturday_open) }}</td>
          <td>{{ this.convertTime(brewery.brewery_hours.saturday_close) }}</td>
        </tr>
      </table>
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


        <!-- <div>
          <div>
            Email: <span>{{ brewery.brewery_contact.email }}</span>
          </div>
          <div>
            Phone: <span>{{ brewery.brewery_contact.phone }}</span>
          </div>
          <div>
            Address: <span>{{ brewery.brewery_contact.brewery_address }}</span>
          </div>
        </div> -->
    

    <div class="beers">
        <button class="btn-see-beers" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id }})">See Beers</button>
    </div>
    <div>
        <button class="btn-edit-contact" v-on:click="$router.push({ name: 'EditContactView', params: { breweryId: brewery.brewery_id }})">Edit Contact Info</button>
    </div>
</template>
  
<script>
  export default {
    props: {
      brewery: { type: Object, required: false }
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
      }
    } 
  }
</script>
  

  
<style>



</style>
  