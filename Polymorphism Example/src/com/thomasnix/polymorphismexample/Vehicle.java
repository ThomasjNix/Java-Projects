package com.thomasnix.polymorphismexample;

public class Vehicle {

    private int numWheels = 4;
    private String vehicleNoise = "Generic Noise!";

    public int getNumWheels(){
        return numWheels;
    }

    public void setNumWheels(int num){
        numWheels = num;
    }

    public String getVehicleNoise(){
        return vehicleNoise;
    }

    public void setVehicleNoise(String noise){
        vehicleNoise = noise;
    }

    public void giveDescription(){
        System.out.println("Vehicle:\n\tThis is a generic vehicle");
    }

    public void doWheelie(Motorcycle someMotorcycle){
        System.out.println("Motorcycle Wheelie:\n\tThat was pretty cool");
    }

    public void doWheelie(Car someCar){
        System.out.println("Car Wheelie:\n\tYou are now upside down.");
        if (someCar.hasColor()){
            System.out.println("\tBut at least your cool " + someCar.getColor() + " car is upside down!");
        }
    }

}
