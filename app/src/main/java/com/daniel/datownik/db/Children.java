package com.daniel.datownik.db;

/**
 * Created by Daniel on 23.02.2017.
 */

public class Children {

    Children() {
    }

    @Override
    public String toString() {
        return name;
    }

    public String name;
    public String DayOfBirth;

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        DayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return MonthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        MonthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }

    public String MonthOfBirth;
    public String YearOfBirth;

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
