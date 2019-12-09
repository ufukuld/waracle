import axios from 'axios'
import { API_URL } from '../../Constants'

class CakeDataService {

    getCakeList() {
        return axios.get(`${API_URL}/cakes`);
    }

    addCake(cake) {
        return axios.post(`${API_URL}/cakes/`, cake);
    }
}

export default new CakeDataService()