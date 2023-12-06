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
    import breweryService from '../services/BreweryService';
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
                    brewery_id: this.editBrewery.brewery_id,
                    brewery_name: this.editBrewery.brewery_name,
                    brewery_main_img: this.editBrewery.brewery_main_img,
                    website: this.editBrewery.website,
                    open_hour: this.editBrewery.open_hour,
                    close_hour: this.editBrewery.close_hour,
                    history: this.edit.brewery_history
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