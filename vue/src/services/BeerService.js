import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list(breweryId) {
        return http.get(`breweries/${breweryId}/beers`);
    },

    get(id) {
        return http.get(`/beers/${id}`);
    },

    addBeer(beer) {
        return http.post(`breweries/${beer.brewery_id}/beers`, beer);
    },

    // updateBeer(beer) {
    //     return http.put(`breweries/${beer.brewery_id}/beers/${beer.beerId}`, beer);
    // },

    deleteBeer(beerId) {
        return http.delete(`/beers/${beerId}`);
    }

}