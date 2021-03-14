package tech.czatmat.app.CzatMatApp.dataClasses.keys.keys_users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("keys_users")
public class KeyUser {

    @Id
    private int id;
    private int user_id;
    private int key_id;

    public KeyUser() {
    }

    public KeyUser(int id, int user_id, int key_id) {
        this.id = id;
        this.user_id = user_id;
        this.key_id = key_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }
}
