<template>
    <div class="text-center">
        <h1>Add Brewery</h1>
        <brewery-form v-bind:brewery="brewery"/>>
    </div>
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
                open_hour: null,
                close_hour: null,
                history: '',
                brewery_contact: {
                    brewery_id: 0,
                    email: '',
                    phone: '',
                    brewery_address: ''
                }
            }
        }
    }
}
</script>

