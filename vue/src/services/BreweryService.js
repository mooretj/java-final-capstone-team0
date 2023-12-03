import axios from 'axios';

export default {

    list() {
        return axios.get('/breweries');
    },

    add(brewery) {
        return axios.post('/new_brewery', brewery);
    }

}