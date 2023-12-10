<template>

    <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>

    <div v-else>
      <brewery-hours-form v-bind:brewery="brewery"/>
    </div>

</template>

<script>
import BreweryHoursForm from '../components/BreweryHoursForm.vue';
import breweryService from '../services/BreweryService';

export default {
    components: {
        BreweryHoursForm
    },
    data() {
        return {
            // breweryId: this.$route.params.breweryId,
            brewery: {},
            // hours: {},
            isLoading: true
        }
    },
    methods: {
        getBreweryHours(id) {
            breweryService.get(id)
            .then(response => {
                this.brewery = response.data;
                this.isLoading = false;
            })
            .catch(error => {
                this.handleErrorResponse(error);
            })
        },
        handleErrorResponse(error) {
            if (error.response.status == 404) {
                this.$router.push({name: 'NotFoundView'});
            }
        }
    },
    // setHours() {
    //     this.hours = this.brewery.hours;
    // },
    created() {
        this.getBreweryHours(this.$route.params.breweryId);
        // this.setHours;
    }
}
</script>

<style>
</style>