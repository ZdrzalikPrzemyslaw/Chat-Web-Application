package tech.czatmat.app.CzatMatApp.payload.response;

import tech.czatmat.app.CzatMatApp.dataClasses.users.User;

import java.util.ArrayList;
import java.util.List;

public class SearchMultipleUsersResponse {

    private List<UserDataResponse> users;

    public SearchMultipleUsersResponse(Iterable<User> usersIterable) {
        users = new ArrayList<>();
        for (var i : usersIterable) {
            users.add(new UserDataResponse(i));
        }
    }

    public List<UserDataResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserDataResponse> users) {
        this.users = users;
    }
}
