package com.thomasnix.polymorphismexample;

public class Boat extends Vehicle {

    Boat(){
        setNumWheels(0);
        setVehicleNoise("BOAT NOISE");
    }

    public void giveDescription(){
        System.out.println("Boat:\n\tThis is a water vehicle... it doesn't have wheels.");
    }
}
