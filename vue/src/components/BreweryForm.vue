<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">

            <div class="form-input-group">
                <label for="name">Brewery Name: </label>
                <input type="text" id="name" v-model="editBrewery.brewery_name" required />
            </div>

            <div class="form-input-group">
                <label for="website">Website URL: </label>
                <input type="text" id="website" v-model="editBrewery.website" />
            </div>

            <div class="form-input-group">
                <label for="mainImg">Brewery Image: </label>
                <input type="text" id="mainImg" v-model="editBrewery.brewery_main_img" />
            </div>

            <div class="form-input-group">
                <label for="history">Short History: </label>
                <input type="text" id="history" v-model="editBrewery.history" />
            </div>

            <div class="form-input-group">
                <label for="email">Email:</label>
                <input type="text" id="email" v-model="editBrewery.brewery_contact.email">
            </div>
            <div class="form-input-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" v-model="editBrewery.brewery_contact.phone">
            </div>
            <div class="form-input-group">
                <label for="address">Address:</label>
                <input type="text" id="address" v-model="editBrewery.brewery_contact.brewery_address">
            </div>

            <label for="hours">Hours of Operation</label>
            <div class="form-input-group">
                <label for="sunday">Sunday:</label>
                <input type="time" id="sunday" v-model="editBrewery.brewery_hours.sunday_open"> -
                <input type="time" id="sunday" v-model="editBrewery.brewery_hours.sunday_close">
            </div>

            <div class="form-input-group">
                <label for="monday">Monday:</label>
                <input type="time" id="monday" v-model="editBrewery.brewery_hours.monday_open"> -
                <input type="time" id="monday" v-model="editBrewery.brewery_hours.monday_close">
            </div>

            <div class="form-input-group">
                <label for="tuesday">Tuesday: </label>
                <input type="time" id="tuesday" v-model="editBrewery.brewery_hours.tuesday_open"> -
                <input type="time" id="tuesday" v-model="editBrewery.brewery_hours.tuesday_close">
            </div>

            <div class="form-input-group">
                <label for="wednesday">Wednesday: </label>
                <input type="time" id="wednesday" v-model="editBrewery.brewery_hours.wednesday_open"> -
                <input type="time" id="wednesday" v-model="editBrewery.brewery_hours.wednesday_close">
            </div>

            <div class="form-input-group">
                <label for="thursday">Thursday: </label>
                <input type="time" id="thursday" v-model="editBrewery.brewery_hours.thursday_open"> -
                <input type="time" id="thursday" v-model="editBrewery.brewery_hours.thursday_close">
            </div>

            <div class="form-input-group">
                <label for="friday">Friday: </label>
                <input type="time" id="friday" v-model="editBrewery.brewery_hours.friday_open"> -
                <input type="time" id="friday" v-model="editBrewery.brewery_hours.friday_close">
            </div>

            <div class="form-input-group">
                <label for="saturday">Saturday: </label>
                <input type="time" id="saturday" v-model="editBrewery.brewery_hours.saturday_open"> -
                <input type="time" id="saturday" v-model="editBrewery.brewery_hours.saturday_close">
            </div>

            <button type="submit" v-on:click="submit">Add Brewery</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </form>
    </div>
</template>

<script>
    import breweryService from '../services/BreweryService.js';
    export default {
        props: {
            brewery: {
                type: Object,
                required: true
            }
        },
        data() {
            return {
                editBrewery: {
                    brewery_id: this.brewery.brewery_id,
                    brewery_name: this.brewery.brewery_name,
                    brewery_main_img: this.brewery.brewery_main_img,
                    website: this.brewery.website,
                    history: this.brewery.brewery_history,
                    brewery_contact: {
                        brewery_id: this.brewery.brewery_id,
                        email: this.brewery.brewery_contact.email,
                        phone: this.brewery.brewery_contact.phone,
                        brewery_address: this.brewery.brewery_contact.brewery_address
                    },
                    brewery_hours: {
                        brewery_id: this.brewery.brewery_hours.brewery_id,
                        sunday_open: this.brewery.brewery_hours.sunday_open,
                        sunday_close: this.brewery.brewery_hours.sunday_close,
                        monday_open: this.brewery.brewery_hours.monday_open,
                        monday_close: this.brewery.brewery_hours.monday_close,
                        tuesday_open: this.brewery.brewery_hours.tuesday_open,
                        tuesday_close: this.brewery.brewery_hours.tuesday_close,
                        wednesday_open: this.brewery.brewery_hours.wednesday_open,
                        wednesday_close: this.brewery.brewery_hours.wednesday_close,
                        thursday_open: this.brewery.brewery_hours.thursday_open,
                        thursday_close: this.brewery.brewery_hours.thursday_close,
                        friday_open: this.brewery.brewery_hours.friday_open,
                        friday_close: this.brewery.brewery_hours.friday_close,
                        saturday_open: this.brewery.brewery_hours.saturday_open,
                        saturday_close: this.brewery.brewery_hours.saturday_close
                    }
                }
            }
        },
        methods: {
            submitForm() {
                // if (!this.validateForm()) {
                //     return;
                // }
                // if (this.editBrewery.brewery_id == 0) {
                    breweryService
                    .addBrewery(this.editBrewery)
                    .then(response => {
                        // if (response.status == 201) {
                        // this.$store.commit(
                        //   'SET_NOTIFICATION',
                        //   {
                        //     message: 'A new beer was added.',
                        //     type: 'success'
                        //   }
                        // );
                        this.$router.push({ name: 'BreweryListView'});
                        // }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, 'adding');
                    });
                // } else {
                //     breweryService
                //     .updateBrewery(this.editBeer)
                //     .then(response => {
                //         // if (response.status == 201) {
                //         // this.$store.commit(
                //         //     'SET_NOTIFICATION',
                //         //     {
                //         //     message: `Message ${this.editBeer.name} was updated.`,
                //         //     type: 'success'
                //         //     }
                //         // );
                //         this.$router.push({ name: 'BeerDetailsView', params: { beerId: this.editBeer.beer_id }});
                //     })
                //     .catch(error => {
                //         this.handleErrorResponse(error, 'updating');
                //     });
                // } 
            },
            cancelForm() {
                this.$router.push({ name: "BreweryListView" });
            },
            // handleErrorResponse(error, verb) {
            //     if (error.response) {
            //         if (error.response.status == 404) {
            //         this.$router.push({name: 'NotFoundView'});
            //         } else {
            //         this.$store.commit('SET_NOTIFICATION',
            //         `Error ${verb} message. Response received was "${error.response.statusText}".`);
            //         }
            //     } else if (error.request) {
            //         this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Server could not be reached.`);
            //     } else {
            //         this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Request could not be created.`);
            //     }
            // }
        },
    
    }
</script>

<style>
   
</style>