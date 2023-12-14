<template>
       
    <form v-on:submit.prevent="submitForm">
        <div><h1>Add Brewery</h1></div>
    <div class="form">
        
        <div class="formLeft">
            <div>
                <input type="text" id="name" class="textEntry" v-model="editBrewery.brewery_name" required
                    placeholder="Brewery Name" />
            </div>

            <div>
                <input type="text" id="website" class="textEntry" v-model="editBrewery.website" placeholder="Website URL" />
            </div>

            <div>
                <input type="text" id="mainImg" class="textEntry" v-model="editBrewery.brewery_main_img"
                    placeholder="Brewery Image" />
            </div>
            <input type="text" id="address" class="textEntry" v-model="editBrewery.brewery_contact.brewery_address"
                placeholder="Address" />

            <div>
                <input type="text" id="logoImg" class="textEntry" v-model="editBrewery.brewery_logo_img"
                    placeholder="Brewery Logo URL" />
            </div>


            <div>
                <input type="text" id="email" class="textEntry" v-model="editBrewery.brewery_contact.email"
                    placeholder="Email" />
            </div>

            <div>
                <input type="text" id="phone" class="textEntry" v-model="editBrewery.brewery_contact.phone"
                    placeholder="Phone Number" />
            </div>

            <div>
                <textarea name="history" id="history" rows="5" placeholder="About Us" class="history"
                    v-model="editBrewery.history"></textarea>
            </div>
        </div>
        <div class="formRight">
            <table>
                <tbody>
                    <tr>
                        <td> <label for="hours">Hours of Operation</label></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="border_bottom">
                        <td> <label for="sunday">Sunday:</label>
                        </td>
                        <td> <input type="time" id="sunday" :disabled="sundayNull"
                                v-model="editBrewery.brewery_hours.sunday_open"> -
                            <input type="time" id="sunday" :disabled="sundayNull"
                                v-model="editBrewery.brewery_hours.sunday_close">
                        </td>
                        <td> <label for="sunday">Closed for the day:</label>
                            <input type="checkbox" id="sunday" @click="sundayNull = !sundayNull">
                        </td>
                    </tr>
                    <tr class="border_bottom">
                        <td> <label for="monday">Monday:</label></td>
                        <td> <input type="time" id="monday" :disabled="mondayNull"
                                v-model="editBrewery.brewery_hours.monday_open"> -
                            <input type="time" id="monday" :disabled="mondayNull"
                                v-model="editBrewery.brewery_hours.monday_close">
                        </td>
                        <td> <label for="monday">Closed for the day:</label>
                            <input type="checkbox" id="monday" @click="mondayNull = !mondayNull">
                        </td>
                    </tr>
                    <tr class="border_bottom">
                        <td> <label for="tuesday">Tuesday: </label></td>
                        <td> <input type="time" id="tuesday" :disabled="tuesdayNull"
                                v-model="editBrewery.brewery_hours.tuesday_open"> -
                            <input type="time" id="tuesday" :disabled="tuesdayNull"
                                v-model="editBrewery.brewery_hours.tuesday_close">
                        </td>
                        <td> <label for="tuesday">Closed for the day:</label>
                            <input type="checkbox" id="tuesday" @click="tuesdayNull = !tuesdayNull">
                        </td>
                    </tr>
                    <tr class="border_bottom">
                        <td><label for="wednesday">Wednesday: </label></td>
                        <td> <input type="time" id="wednesday" :disabled="wednesdayNull"
                                v-model="editBrewery.brewery_hours.wednesday_open">
                            -
                            <input type="time" id="wednesday" :disabled="wednesdayNull"
                                v-model="editBrewery.brewery_hours.wednesday_close">
                        </td>
                        <td> <label for="wednesday">Closed for the day:</label>
                            <input type="checkbox" id="wednesday" @click="wednesdayNull = !wednesdayNull">
                        </td>
                    </tr>
                    <tr class="border_bottom">
                        <td><label for="thursday">Thursday: </label></td>
                        <td> <input type="time" id="thursday" :disabled="thursdayNull"
                                v-model="editBrewery.brewery_hours.thursday_open">
                            -
                            <input type="time" id="thursday" :disabled="thursdayNull"
                                v-model="editBrewery.brewery_hours.thursday_close">
                        </td>
                        <td> <label for="thursday">Closed for the day:</label>
                            <input type="checkbox" id="thursday" @click="thursdayNull = !thursdayNull">
                        </td>
                    </tr>
                    <tr class="border_bottom">
                        <td><label for="friday">Friday: </label></td>
                        <td> <input type="time" id="friday" :disabled="fridayNull"
                                v-model="editBrewery.brewery_hours.friday_open"> -
                            <input type="time" id="friday" :disabled="fridayNull"
                                v-model="editBrewery.brewery_hours.friday_close">
                        </td>
                        <td> <label for="friday">Closed for the day:</label>
                            <input type="checkbox" id="friday" @click="fridayNull = !fridayNull">
                        </td>
                    </tr>
                    <tr>
                        <td> <label for="saturday">Saturday: </label></td>
                        <td> <input type="time" id="saturday" :disabled="saturdayNull"
                                v-model="editBrewery.brewery_hours.saturday_open">
                            -
                            <input type="time" id="saturday" :disabled="saturdayNull"
                                v-model="editBrewery.brewery_hours.saturday_close">
                        </td>
                        <td> <label for="saturday">Closed for the day:</label>
                            <input type="checkbox" id="saturday" @click="saturdayNull = !saturdayNull">
                        </td>
                    </tr>


                </tbody>
            </table>

        </div>

    </div>
    <div class="submitcancel">
            <div>
                <button class="button" type="submit" v-on:click="submit">Add Brewery</button>
                <button class="button" type="button" v-on:click="cancelForm">Cancel</button>
            </div>
        </div>
</form>
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
                    brewery_name: this.brewery.brewery_name,
                    brewery_main_img: this.brewery.brewery_main_img,
                    brewery_logo_img: this.brewery.brewery_logo_img,
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
                    this.$router.push({ name: 'BreweryListView' });
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

<style scoped>

form{
    width: 100%;
}
.form {
    background-color: black;

    opacity: .8;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 60vh;
}


.formLeft {
    width: 40vw;
    text-align: center;

}

.text {
    text-align: center;

}

.formRight {
    display: flex;
    align-items: top;
    justify-content: center;
    width: 40vw;
}

.textEntry {
    width: 75%;
    margin: 3px;
    height: 28px;
    font-size: 22px;
}

table {
    border-spacing: 0 10px;

}

tr.border_bottom td {
    border-bottom: 1px solid white;

}

.history {
    width: 75%;
    resize: none;
    margin: 3px;
    font-size: 22px;;
}

.button {
    width: 200px;



}
.submitcancel{
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>