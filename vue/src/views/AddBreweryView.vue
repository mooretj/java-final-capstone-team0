<template>
        <brewery-form v-bind:brewery="brewery"/>
</template>

<script>
import BreweryForm from '../components/BreweryForm.vue'

export default {
    components:  {
        BreweryForm
    },
    data() {
        return {
            brewery: {
                brewery_id: 0,
                brewery_name: '',
                brewery_main_img: '',
                website: '',
                history: '',
                brewery_contact: {
                    brewery_id: 0,
                    email: '',
                    phone: '',
                    brewery_address: ''
                },
                brewery_hours: {
                    brewery_id: 0,
                    sunday_open: null,
                    sunday_close: null,
                    monday_open: null,
                    monday_close: null,
                    tuesday_open: null,
                    tuesday_close: null,
                    wednesday_open: null,
                    thursday_open: null,
                    thursday_close: null,
                    friday_open: null,
                    friday_close: null,
                    saturday_open: null,
                    saturday_close: null,
                }
            }
        }
    }
}
</script>

<style>
h1{
    margin-top: 0px;
  margin-left: 28px;
  margin-bottom: 0px;
  font-size: 28px;
  color: white;
  text-shadow: black 3px 3px 4px;
  z-index: 1;
}
</style>

