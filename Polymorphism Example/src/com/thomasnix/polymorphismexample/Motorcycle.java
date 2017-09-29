package com.thomasnix.polymorphismexample;

public class Motorcycle extends Vehicle {

    Motorcycle(){
        setNumWheels(2);
        setVehicleNoise("Vroom also but for bikes.");
    }

    public void giveDescription(){
        System.out.println("Motorcycle:\n\tThis is a two wheeled land vehicle");
    }
}
