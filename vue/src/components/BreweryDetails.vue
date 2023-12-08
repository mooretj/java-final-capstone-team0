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

    <div class="hours">
      <label>Hours of Operation</label>&nbsp;
      <div class="week">
        <div>
          Sunday: {{ brewery.brewery_hours.sunday_open.slice(0, 5) }} - {{ brewery.brewery_hours.sunday_close.slice(0, 5) }}
        </div>
        <div>
          Monday: {{ brewery.brewery_hours.monday_open.slice(0, 5) }} - {{ brewery.brewery_hours.monday_close.slice(0, 5) }}
        </div>
        <div>
          Tuesday: {{ brewery.brewery_hours.tuesday_open.slice(0, 5) }} - {{ brewery.brewery_hours.tuesday_close.slice(0, 5) }}
        </div>
        <div>
          Wednesday: {{ brewery.brewery_hours.wednesday_open.slice(0, 5) }} - {{ brewery.brewery_hours.wednesday_close.slice(0, 5) }}
        </div>
        <div>
          Thursday: {{ brewery.brewery_hours.thursday_open.slice(0, 5) }} - {{ brewery.brewery_hours.thursday_close.slice(0, 5) }}
        </div>
        <div>
          Friday: {{ brewery.brewery_hours.friday_open.slice(0, 5) }} - {{ brewery.brewery_hours.friday_close.slice(0, 5) }}
        </div>
        <div>
          Saturday: {{ brewery.brewery_hours.saturday_open.slice(0, 5) }} - {{ brewery.brewery_hours.saturday_close.slice(0, 5) }}
        </div>
      </div>
    </div>

    <div class="contact-info">
      <label>Contact Info</label>
      <div>
        <div>
          Email: <span>{{ brewery.brewery_contact.email }}</span>
        </div>
        <div>
          Phone: <span>{{ brewery.brewery_contact.phone }}</span>
        </div>
        <div>
          Address: <span>{{ brewery.brewery_contact.brewery_address }}</span>
        </div>
      </div>
    </div>

    <div class="beers">
        <button class="btn-see-beers" v-on:click="$router.push({ name: 'BeerListView', params: { breweryId: brewery.brewery_id }})">See Beers</button>
    </div>
    <div>
        <button class="btn-edit-contact" v-on:click="editContact">Edit Contact Info</button>
    </div>
</template>
  
<script>
  export default {
    props: {
      brewery: { type: Object, required: false }
    },
    methods: {
      editContact() {
        if(this.$store.state.user.brewer == true || this.$store.state.user.authorities[0].name == "ROLE_ADMIN") {
          this.$router.push({ name: 'EditContactView', params: { breweryId: this.brewery.brewery_id }})
        }
        else {
          alert("You must be authorized to do that.")
        }
      }
    }   
  }
</script>
  

  
<style>

</style>
  