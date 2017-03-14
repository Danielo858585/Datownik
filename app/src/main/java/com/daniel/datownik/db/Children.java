package com.daniel.datownik.db;

/**
 * Created by Daniel on 23.02.2017.
 */

public class Children {

    public int id;
    public String name;
    public String dayOfBirth;
    public String monthOfBirth;
    public String yearOfBirth;


    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOFBirth) {
        this.monthOfBirth = monthOFBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOFBirth) {
        this.yearOfBirth = yearOFBirth;
    }

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

    public Children() {
    }

    @Override
    public String toString() {
        return name;
    }

}
