import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get('/beers');
    },

    get(id) {
        return http.get(`/beers/${id}`);
    },

    add(beer) {
        return http.post('/beers', beer);
    },

    updateBeer(beer) {
        return http.put(`/beers/${beer.id}`, beer);
    },

    deleteBeer(beerId) {
        return http.delete(`/beers/${beerId}`);
    },

}