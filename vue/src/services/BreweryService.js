import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get('/breweries');
    },

    get(breweryId) {
        return http.get(`/breweries/${breweryId}`);
    },

    addBrewery(brewery) {
        return http.post('/breweries', brewery);
    },

    editContact(contact) {
        return http.put('/brewery/:breweryId/edit-contact', contact);
    }

}