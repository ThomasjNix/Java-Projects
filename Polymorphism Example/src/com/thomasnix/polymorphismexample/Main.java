package com.thomasnix.polymorphismexample;

public class Main {

    public static void main(String args[]){
        Vehicle someVehicle = new Vehicle();
        Car aCar = new Car("red");
        Car anotherCar = new Car("blue");
        Car aThirdCar = new Car();
        Boat aBoat = new Boat();
        Motorcycle aMoto = new Motorcycle();

        someVehicle.giveDescription();
        aCar.giveDescription();
        aThirdCar.giveDescription();
        aBoat.giveDescription();
        aMoto.giveDescription();

        someVehicle.doWheelie(aMoto);
        someVehicle.doWheelie(anotherCar);
        someVehicle.doWheelie(aThirdCar);
    }
}
