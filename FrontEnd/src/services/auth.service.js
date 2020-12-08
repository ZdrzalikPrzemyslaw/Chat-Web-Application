import axios from 'axios';

class AuthService {
    login(user) {
        return axios
            .post(process.env.VUE_APP_BACKEND_URL + "/login", {
                username: user.username,
                password: user.password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data)) //zapisujemy JWT do Local Storage
                }
                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('user');
    }

    register(user) {
        return axios.post(process.env.VUE_APP_BACKEND_URL + "/registration", {
            username: user.username,
            password: user.password,
            name: user.name,
            surname: user.surname,
            email: user.email
        });
    }
}

export default new AuthService();