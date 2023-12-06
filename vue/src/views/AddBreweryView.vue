<template>
    <div class="text-center">
        <h1>Add Brewery</h1>
        <brewery-form/>>
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
    }
}
</script>

