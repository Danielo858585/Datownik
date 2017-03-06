package com.daniel.datownik.db;

/**
 * Created by Daniel on 23.02.2017.
 */

public class Children {

    public Children() {
    }

    @Override
    public String toString() {
        return name;
    }

    public String name;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
