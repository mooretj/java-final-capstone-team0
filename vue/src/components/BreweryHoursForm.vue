<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">

            <h1>Edit Hours of Operation</h1>

            <div class="form-input-group">
                <label for="sunday">Sunday:</label>
                <input type="time" id="sunday" :disabled="sundayNull" v-model="editHours.sunday_open"> -
                <input type="time" id="sunday" :disabled="sundayNull" v-model="editHours.sunday_close">&nbsp;
                <label for="sunday">Closed for the day:</label>
                <input type="checkbox" id="sunday"  @click="sundayNull = !sundayNull">
            </div>

            <div class="form-input-group">
                <label for="monday">Monday:</label>
                <input type="time" id="monday" :disabled="mondayNull" v-model="editHours.monday_open"> -
                <input type="time" id="monday" :disabled="mondayNull" v-model="editHours.monday_close">&nbsp;
                <label for="monday">Closed for the day:</label>
                <input type="checkbox" id="monday"  @click="mondayNull = !mondayNull">
            </div>

            <div class="form-input-group">
                <label for="tuesday">Tuesday: </label>
                <input type="time" id="tuesday" :disabled="tuesdayNull" v-model="editHours.tuesday_open"> -
                <input type="time" id="tuesday" :disabled="tuesdayNull" v-model="editHours.tuesday_close">&nbsp;
                <label for="tuesday">Closed for the day:</label>
                <input type="checkbox" id="tuesday"  @click="tuesdayNull = !tuesdayNull">
            </div>

            <div class="form-input-group">
                <label for="wednesday">Wednesday: </label>
                <input type="time" id="wednesday" :disabled="wednesdayNull" v-model="editHours.wednesday_open"> -
                <input type="time" id="wednesday" :disabled="wednesdayNull" v-model="editHours.wednesday_close">&nbsp;
                <label for="wednesday">Closed for the day:</label>
                <input type="checkbox" id="wednesday"  @click="wednesdayNull = !wednesdayNull">
            </div>

            <div class="form-input-group">
                <label for="thursday">Thursday: </label>
                <input type="time" id="thursday" :disabled="thursdayNull" v-model="editHours.thursday_open"> -
                <input type="time" id="thursday" :disabled="thursdayNull" v-model="editHours.thursday_close">&nbsp;
                <label for="thursday">Closed for the day:</label>
                <input type="checkbox" id="thursday" @click="thursdayNull = !thursdayNull">
            </div>

            <div class="form-input-group">
                <label for="friday">Friday: </label>
                <input type="time" id="friday" :disabled="fridayNull" v-model="editHours.friday_open"> -
                <input type="time" id="friday" :disabled="fridayNull" v-model="editHours.friday_close">&nbsp;
                <label for="friday">Closed for the day:</label>
                <input type="checkbox" id="friday"  @click="fridayNull = !fridayNull">
            </div>

            <div class="form-input-group">
                <label for="saturday">Saturday: </label>
                <input type="time" id="saturday" :disabled="saturdayNull" v-model="editHours.saturday_open"> -
                <input type="time" id="saturday" :disabled="saturdayNull" v-model="editHours.saturday_close">&nbsp;
                <label for="saturday">Closed for the day:</label>
                <input type="checkbox" id="saturday"  @click="saturdayNull = !saturdayNull">
            </div>

            <button type="submit" v-on:click="submit">Submit</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
            
        </form>
    </div>
</template>
    
<script>
import breweryService from '../services/BreweryService'

export default {
    props: {
        brewery: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            sundayNull: this.brewery.brewery_hours.sunday_open == "00:00:00" && this.brewery.brewery_hours.sunday_close == "00:00:00",
            mondayNull: this.brewery.brewery_hours.monday_open == "00:00:00" && this.brewery.brewery_hours.monday_close == "00:00:00",
            tuesdayNull: this.brewery.brewery_hours.tuesday_open == "00:00:00" && this.brewery.brewery_hours.tuesday_close == "00:00:00",
            wednesdayNull: this.brewery.brewery_hours.wednesday_open == "00:00:00" && this.brewery.brewery_hours.wednesday_close == "00:00:00",
            thursdayNull: this.brewery.brewery_hours.thursday_open == "00:00:00" && this.brewery.brewery_hours.thursday_close == "00:00:00",
            fridayNull: this.brewery.brewery_hours.friday_open == "00:00:00" && this.brewery.brewery_hours.friday_close == "00:00:00",
            saturdayNull: this.brewery.brewery_hours.saturday_open == "00:00:00" && this.brewery.brewery_hours.saturday_close == "00:00:00",
            breweryId: this.$route.params.breweryId,
            editHours: {
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
    },
    methods: {
        submitForm() {
            if (   this.editHours.sunday_open == null 
                || this.editHours.sunday_close == null 
                || this.editHours.monday_open == null 
                || this.editHours.monday_close == null 
                || this.editHours.tuesday_open == null 
                || this.editHours.tuesday_close == null 
                || this.editHours.wednesday_open == null 
                || this.editHours.wednesday_close == null 
                || this.editHours.thursday_open == null 
                || this.editHours.thursday_close == null
                || this.editHours.friday_open == null 
                || this.editHours.friday_close == null 
                || this.editHours.saturday_open == null
                || this.editHours.saturday_close == null
            ) {
                alert("Please select an option for each day");
            } else {
                this.adjustForClosedDays();
                breweryService
                .editHours(this.editHours, this.$route.params.breweryId)
                .then(response => {
                    // if (response.status == 201) {
                    //     this.$store.commit(
                    //         'SET_NOTIFICATION',
                    //         {
                    //             message: 'A new brewery was added.',
                    //             type: 'success'
                    //         }
                    //     );

                    // }
                    this.$router.push({ name: "BreweryDetailsView", params: { breweryId: this.$route.params.breweryId } });
                })
              .catch(error => {
                this.handleErrorResponse(error, 'adding');
              });
            }
        },
        cancelForm() {
            this.$router.push({ name: "BreweryDetailsView", params: { breweryId: this.$route.params.breweryId }  });
        },
        adjustForClosedDays() {
            if (this.sundayNull) {
                this.editHours.sunday_open = "00:00:00";
                this.editHours.sunday_close = "00:00:00";
            }
            if (this.mondayNull) {
                this.editHours.monday_open = "00:00:00";
                this.editHours.monday_close = "00:00:00";
            }
            if (this.tuesdayNull) {
                this.editHours.tuesday_open = "00:00:00";
                this.editHours.tuesday_close = "00:00:00";
            }
            if (this.wednesdayNull) {
                this.editHours.wednesday_open = "00:00:00";
                this.editHours.wednesday_close = "00:00:00";
            }
            if (this.thursdayNull) {
                this.editHours.thursday_open = "00:00:00";
                this.editHours.thursday_close = "00:00:00";
            }
            if (this.fridayNull) {
                this.editHours.friday_open = "00:00:00";
                this.editHours.friday_close = "00:00:00";
            }
            if (this.saturdayNull) {
                this.editHours.saturday_open = "00:00:00";
                this.editHours.saturday_close = "00:00:00";
            }
        }
    }
}
</script>