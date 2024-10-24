package com.bikerental;

public class Bike {
    private String model;
    private double rentalPrice;

    public Bike(String model, double rentalPrice) {
        this.model = model;
        this.rentalPrice = rentalPrice;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
}