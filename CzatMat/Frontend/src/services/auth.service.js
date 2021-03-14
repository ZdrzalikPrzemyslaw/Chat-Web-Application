import axios from 'axios';

// klasa zawierająca metody do logowania, wylogowywania i rejestrowania z wykorzystaniem HTTP requestow
class AuthService {
    // za pomoca POST przekazujemy login i haslo, o odpowiedzi otrzymujemy JWT token, ktory zapisujemy do local storage
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

    // usuwamy JWT token z local storage
    logout() {
        localStorage.removeItem('user');
    }

    // za pomocą POST przekazujemy dane rejestrowanego użytkownika
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