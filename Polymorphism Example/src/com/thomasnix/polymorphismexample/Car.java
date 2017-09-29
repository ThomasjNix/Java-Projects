package com.thomasnix.polymorphismexample;

public class Car extends Vehicle{
    private String color;

    Car(){
        setVehicleNoise("Vroom!");
    }
    Car(String colorVal){
        setVehicleNoise("Vroom!");
        color = colorVal;
    }

    public boolean hasColor(){
        if (color!= null){
            return true;
        }else{
            return false;
        }
    }

    public String getColor(){
        if (hasColor()){
            return color;
        }else{
            return "This car has no set color!";
        }
    }

    public void giveDescription(){
        System.out.println("Car:\n\tThis is a 4 wheeled land vehicle");
        if (hasColor()){
            System.out.println("\tThis car has a color! It is " + color);
        }
    }
}
