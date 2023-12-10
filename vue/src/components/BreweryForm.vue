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
                <input type="time" id="sunday" :disabled="sundayNull" v-model="editBrewery.brewery_hours.sunday_open"> -
                <input type="time" id="sunday" :disabled="sundayNull" v-model="editBrewery.brewery_hours.sunday_close">&nbsp;
                <label for="sunday">Closed for the day:</label>
                <input type="checkbox" id="sunday" @click="sundayNull = !sundayNull">
            </div>

            <div class="form-input-group">
                <label for="monday">Monday:</label>
                <input type="time" id="monday" :disabled="mondayNull" v-model="editBrewery.brewery_hours.monday_open"> -
                <input type="time" id="monday" :disabled="mondayNull" v-model="editBrewery.brewery_hours.monday_close">&nbsp;
                <label for="monday">Closed for the day:</label>
                <input type="checkbox" id="monday" @click="mondayNull = !mondayNull">
            </div>

            <div class="form-input-group">
                <label for="tuesday">Tuesday: </label>
                <input type="time" id="tuesday" :disabled="tuesdayNull" v-model="editBrewery.brewery_hours.tuesday_open"> -
                <input type="time" id="tuesday" :disabled="tuesdayNull" v-model="editBrewery.brewery_hours.tuesday_close">&nbsp;
                <label for="tuesday">Closed for the day:</label>
                <input type="checkbox" id="tuesday" @click="tuesdayNull = !tuesdayNull">
            </div>

            <div class="form-input-group">
                <label for="wednesday">Wednesday: </label>
                <input type="time" id="wednesday" :disabled="wednesdayNull" v-model="editBrewery.brewery_hours.wednesday_open"> -
                <input type="time" id="wednesday" :disabled="wednesdayNull" v-model="editBrewery.brewery_hours.wednesday_close">&nbsp;
                <label for="wednesday">Closed for the day:</label>
                <input type="checkbox" id="wednesday" @click="wednesdayNull = !wednesdayNull">
            </div>

            <div class="form-input-group">
                <label for="thursday">Thursday: </label>
                <input type="time" id="thursday" :disabled="thursdayNull" v-model="editBrewery.brewery_hours.thursday_open"> -
                <input type="time" id="thursday" :disabled="thursdayNull" v-model="editBrewery.brewery_hours.thursday_close">&nbsp;
                <label for="thursday">Closed for the day:</label>
                <input type="checkbox" id="thursday" @click="thursdayNull = !thursdayNull">
            </div>

            <div class="form-input-group">
                <label for="friday">Friday: </label>
                <input type="time" id="friday" :disabled="fridayNull" v-model="editBrewery.brewery_hours.friday_open"> -
                <input type="time" id="friday" :disabled="fridayNull" v-model="editBrewery.brewery_hours.friday_close">&nbsp;
                <label for="friday">Closed for the day:</label>
                <input type="checkbox" id="friday" @click="fridayNull = !fridayNull">
            </div>

            <div class="form-input-group">
                <label for="saturday">Saturday: </label>
                <input type="time" id="saturday" :disabled="saturdayNull" v-model="editBrewery.brewery_hours.saturday_open"> -
                <input type="time" id="saturday" :disabled="saturdayNull" v-model="editBrewery.brewery_hours.saturday_close">&nbsp;
                <label for="saturday">Closed for the day:</label>
                <input type="checkbox" id="saturday" @click="saturdayNull = !saturdayNull">
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
        computed: {
            ian: false
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
                },
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
            submitForm() {
                // if (!this.validateForm()) {
                //     return;
                // }
                // if (this.editBrewery.brewery_id == 0) {
                    this.adjustForClosedDays();
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
            adjustForClosedDays() {
                if (this.sundayNull) {
                    this.editBrewery.brewery_hours.sunday_open = "00:00:00";
                    this.editBrewery.brewery_hours.sunday_close = "00:00:00";
                }
                if (this.mondayNull) {
                    this.editBrewery.brewery_hours.monday_open = "00:00:00";
                    this.editBrewery.brewery_hours.monday_close = "00:00:00";
                }
                if (this.tuesdayNull) {
                    this.editBrewery.brewery_hours.tuesday_open = "00:00:00";
                    this.editBrewery.brewery_hours.tuesday_close = "00:00:00";
                }
                if (this.wednesdayNull) {
                    this.editBrewery.brewery_hours.wednesday_open = "00:00:00";
                    this.editBrewery.brewery_hours.wednesday_close = "00:00:00";
                }
                if (this.thursdayNull) {
                    this.editBrewery.brewery_hours.thursday_open = "00:00:00";
                    this.editBrewery.brewery_hours.thursday_close = "00:00:00";
                }
                if (this.fridayNull) {
                    this.editBrewery.brewery_hours.friday_open = "00:00:00";
                    this.editBrewery.brewery_hours.friday_close = "00:00:00";
                }
                if (this.saturdayNull) {
                    this.editBrewery.brewery_hours.saturday_open = "00:00:00";
                    this.editBrewery.brewery_hours.saturday_close = "00:00:00";
                }
        }
        },
    
    }
</script>

<style>
   
</style>