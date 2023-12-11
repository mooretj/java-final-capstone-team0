<template>
    <div class="text-center">
        <form v-on:submit.prevent="submitForm">

            <h1>Edit Contact</h1>

            <div class="form-input-group">
                <label for="email">Email: </label>
                <input type="text" id="email" v-model="editContact.email" />
            </div>

            <div class="form-input-group">
                <label for="phone">Phone: </label>
                <input type="text" id="phone" v-model="editContact.phone" />
            </div>

            <div class="form-input-group">
                <label for="address">Address: </label>
                <input type="text" id="address" v-model="editContact.brewery_address" />
            </div>

            <button type="submit" v-on:click="submit" >Submit</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
            
        </form>
    </div>
</template>

<script>
import breweryService from '../services/BreweryService.js'

export default {
    props: {
        brewery: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            breweryId: this.$route.params.breweryId,
            editContact: {
                email: this.brewery.brewery_contact.email,
                phone: this.brewery.brewery_contact.phone,
                brewery_address: this.brewery.brewery_contact.brewery_address
            }
        }
    },
    methods: {
        submitForm() {
            if(this.editContact.phone.length != 10){
                alert("Not a valid phone number");
            }else{
            breweryService
                .editContact(this.editContact, this.$route.params.breweryId)
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
        }
    }
}
</script>

