// generalnie w tym momencie nie korzystamy z tej funkcji,
// przyda się ona, gdy będziemy robili blokade dla konkretnego
// typu uzytkownika (np. admin moze wejsc na /admin a zwykly
// user nie). Funkcja przeszukuje local storage czy, jest tam
// user (czyli czy jest tam zapisany token). Jesli jest user z
// tokenem zwraca "HTTP Authorization header" (który jest
// potrzebny, aby dostac sie do chronionych zasobow).
// W innym przypadku zwraca pusty obiekt.

export default function authHeader() {
    let user = JSON.parse(localStorage.getItem('user'));

    if (user && user.accessToken) {
        return {
            Authorization: 'Bearer ' + user.accessToken
        };
    } else {
        return {};
    }
}