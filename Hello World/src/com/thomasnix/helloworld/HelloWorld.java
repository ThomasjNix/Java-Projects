package com.thomasnix.helloworld;

public class HelloWorld {

    public static void main(String[] args){

        Planet newPlanet = new Planet("Earth");
        System.out.println("Hello, " + newPlanet.getPlanet() + "!");
        newPlanet.setPlanet("Venus");
        System.out.println("Hello, " + newPlanet.getPlanet() + "!");
    }
}
