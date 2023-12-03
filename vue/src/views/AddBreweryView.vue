<template>
<div class="text-center">
    <form v-on:submit.prevent="addBrewery">
        <h1>Add Brewery</h1>
        <div class="form-input-group">
            <label for="name">Brewery Name: </label>
            <input type="text" id="name" v-model="brewery.name" required />
        </div>
        <div class="form-input-group">
            <label for="website">Website URL: </label>
            <input type="text" id="website" v-model="brewery.website" />
        </div>
        <div class="form-input-group">
            <label for="open">Opening Hour: </label>
            <input type="time" id="open" v-model="brewery.openHour" />
        </div>
        <div class="form-input-group">
            <label for="close">Closing Hour: </label>
            <input type="time" id="close" v-model="brewery.closeHour" />
        </div>
        <div class="form-input-group">
            <label for="history">Short History: </label>
            <input type="history" id="history" v-model="brewery.history" />
        </div>
        <button type="submit">Add Brewery</button>
    </form>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService.js'

export default {
    data() {
        return {
            brewery: {
                name: '',
                website: '',
                openHour: null,
                closeHour: null,
                history: ''
            }
        }
    },
    methods: {
        addBrewery() {
            BreweryService
            .add(this.brewery)
            .then((response) => {
                if (response.status === 201) {
                    this.$router.push({ name: 'HomeView' });
                }
            });
        }
    }
}
</script>

