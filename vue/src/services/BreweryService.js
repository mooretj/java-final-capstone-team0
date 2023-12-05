import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get('/breweries');
    },

    get(id) {
        return http.get(`/breweries/${id}`);
    },

    addBrewery(brewery) {
        return http.post('/breweries', brewery);
    }

}