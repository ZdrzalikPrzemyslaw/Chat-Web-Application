package tech.czatmat.app.CzatMatApp.payload.response;

import tech.czatmat.app.CzatMatApp.dataClasses.users.User;

import java.util.ArrayList;
import java.util.List;

public class SearchMultipleUsersResponse {

    private List<SearchSingleUserResponse> list;

    public SearchMultipleUsersResponse(Iterable<User> usersIterable) {
        list = new ArrayList<>();
        for (var i : usersIterable) {
            list.add(new SearchSingleUserResponse(i));
        }
    }

    public List<SearchSingleUserResponse> getList() {
        return list;
    }

    public void setList(List<SearchSingleUserResponse> list) {
        this.list = list;
    }
}
