package com.daniel.datownik.db.Eat;

/**
 * Created by Daniel on 05.04.2017.
 */

public class Eat {
    public int id;
    public String date;
    public String typeOfFood;
    public String amountOfEaten;


    public Eat(int id, String date, String typeOfFood, String amountOfEaten) {
        this.id = id;
        this.date = date;
        this.typeOfFood = typeOfFood;
        this.amountOfEaten = amountOfEaten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getAmountOfEaten() {
        return amountOfEaten;
    }

    public void setAmountOfEaten(String amountOfEaten) {
        this.amountOfEaten = amountOfEaten;
    }

    public Eat() {

    }
}
