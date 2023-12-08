import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    // If breweryId is 0, all beers are returned
    list(breweryId) {
        return http.get(`breweries/${breweryId}/beers`);
    },

    get(beerId) {
        return http.get(`/beers/${beerId}`);
    },

    getIds() {
        return http.get('/random');
    },

    addBeer(beer) {
        return http.post(`/breweries/${beer.brewery_id}/beers`, beer);
    },

    updateBeer(beer) {
        return http.put(`/beers/${beer.beer_id}`, beer);
    },

    deleteBeer(beerId) {
        return http.delete(`/beers/${beerId}`);
    }

}