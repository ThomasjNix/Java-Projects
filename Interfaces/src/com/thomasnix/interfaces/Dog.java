package com.thomasnix.interfaces;

public class Dog extends Canine implements Pet {

    private String name;

    Dog(String name){
        setName(name);
        setNumLegs(4);
    }

    @Override
    public void play(){
        System.out.println("\t" + getName() + " likes to play!");
    }

    @Override
    public void goForAWalk(){
        System.out.println("\t" + getName() + " goes for a walk!");
    }

    public String getName(){
        return name;
    }

    public void setName(String inVal){
        name = inVal;
    }


}
