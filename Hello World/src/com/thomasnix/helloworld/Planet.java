package com.thomasnix.helloworld;

public class Planet {
    private String whichPlanet;

    Planet(String planet){
        whichPlanet = planet;
    }

    public String getPlanet(){
        return whichPlanet;
    }

    public void setPlanet(String planet){
        whichPlanet = planet;
    }
}
