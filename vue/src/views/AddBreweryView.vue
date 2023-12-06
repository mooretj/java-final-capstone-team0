<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">

            <h1>Add Brewery</h1>

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
                <label for="open">Opening Hour: </label>
                <input type="time" id="open" v-model="editBrewery.open_hour" />
            </div>

            <div class="form-input-group">
                <label for="close">Closing Hour: </label>
                <input type="time" id="close" v-model="editBrewery.close_hour" />
            </div>

            <div class="form-input-group">
                <label for="history">Short History: </label>
                <input type="history" id="history" v-model="editBrewery.history" />
            </div>

            <button type="submit" v-on:click="submit">Add Brewery</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
            
        </form>
    </div>
</template>

<script>
import breweryService from '../services/BreweryService.js'

export default {
    data() {
        return {
            editBrewery: {
                brewery_id: 0,
                brewery_name: '',
                brewery_main_img: '',
                website: '',
                open_hour: null,
                close_hour: null,
                history: ''
            }
        }
    },
    methods: {
        submitForm() {
            breweryService
                .addBrewery(this.editBrewery)
                .then(response => {
                    if (response.status == 201) {
                        this.$store.commit(
                            'SET_NOTIFICATION',
                            {
                                message: 'A new brewery was added.',
                                type: 'success'
                            }
                        );

                    }
                    this.$router.push({ name: "BreweryListView" });
                })
            //   .catch(error => {
            //     this.handleErrorResponse(error, 'adding');
            //   });
        },
        cancelForm() {
            this.$router.push({ name: "BreweryListView" });
        }
    }

}
</script>

