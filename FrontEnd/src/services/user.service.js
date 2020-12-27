// w zasadzie w tym momencie tej klasy nie używamy, ale przy blokadach dla konkretnych klub, czyli np tylko admini mogą
// wejsc na jakis URL sie przyda.
import axios from 'axios';
import authHeader from "./auth-header";

class UserService {
    getPublicContent() {
        return axios.get(process.env.VUE_APP_BACKEND_URL + 'all');
    }

    getUserContent() {
        return axios.get(process.env.VUE_APP_BACKEND_URL + 'user',
            {headers: authHeader()});
    }
    // Tutaj dodajemy jak bedziemy mieli jakies strony, na ktore moga wejsc admini:
    // przyklad ze strony https://bezkoder.com/jwt-vue-vuex-authentication/:
    // getModeratorBoard() {
    //     return axios.get(API_URL + 'mod', { headers: authHeader() });
    // }
    //
    // getAdminBoard() {
    //     return axios.get(API_URL + 'admin', { headers: authHeader() });
    // }
}

export default new UserService();