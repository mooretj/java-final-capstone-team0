<template>

    <form v-on:submit.prevent="submitForm">
        <div><h1>Edit Contact Information</h1></div>
            <div class="form">
                <div class="formLeft">
                    <div>
                        <input type="text" id="email" v-model="editContact.email" required
                    placeholder="Email"/>
                    </div>

                    <div>
                        
                        <input type="text" id="phone" v-model="editContact.phone" required
                    placeholder="Phone Number"/>
                    </div>

                    <div>
                        <input type="text" id="address" v-model="editContact.brewery_address" required
                    placeholder="Address"/>
                    </div>

                </div>
                
            </div>
            <div class="submitcancel"> 
                        <button type="submit" v-on:click="submit" >Submit</button>
                        <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
                    </div>
    </form>
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
    }

    .button {
        width: 200px;



    }
    .submitcancel{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    input {
        width: 100%;
        font-size: 22px;
    }
</style>