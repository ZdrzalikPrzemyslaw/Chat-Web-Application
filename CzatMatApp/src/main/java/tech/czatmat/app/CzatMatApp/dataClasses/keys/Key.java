package tech.czatmat.app.CzatMatApp.dataClasses.keys;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("keys")
public class Key {
    @Id
    private int id;
    private int base_id;
    private String value;

    public Key(int id, int base_id, String value) {
        this.id = id;
        this.base_id = base_id;
        this.value = value;
    }

    public Key() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBase_id() {
        return base_id;
    }

    public void setBase_id(int base_id) {
        this.base_id = base_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
