<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">

            <h1>Edit Contact</h1>

            <div class="form-input-group">
                <label for="email">Email: </label>
                <input type="text" id="email" v-model="editBrewery.brewery_contact.email" />
            </div>

            <div class="form-input-group">
                <label for="phone">Phone: </label>
                <input type="text" id="phone" v-model="editBrewery.brewery_contact.phone" />
            </div>

            <div class="form-input-group">
                <label for="address">Address: </label>
                <input type="text" id="address" v-model="editBrewery.brewery_contact.brewery_address" />
            </div>

            <button type="submit" v-on:click="submit" >Submit</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
            
        </form>
    </div>
</template>

<script>
import breweryService from '../services/BreweryService.js'

export default {
    data() {
        return {
            editContact: {
                brewery_id: this.$route.params.brewery_id,
                email: '',
                phone: '0',
                brewery_address: ''
            }
        }
    },
    methods: {
        submitForm() {
            breweryService
                .editContact(this.editContact)
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
                    this.$router.push({ name: "BreweryDetailsView", params: { brewery_id: this.$route.params.brewery_id } });
                })
            //   .catch(error => {
            //     this.handleErrorResponse(error, 'adding');
            //   });
        },
        cancelForm() {
            this.$router.push({ name: "BreweryDetailsView", params: { brewery_id: this.$route.params.brewery_id }  });
        }
    }

}
</script>

