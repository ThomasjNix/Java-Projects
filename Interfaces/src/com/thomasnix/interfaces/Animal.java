package com.thomasnix.interfaces;

public abstract class Animal {
    private int numLegs;
    private double weight;

    public int getNumLegs() {
        return numLegs;
    }

    public double getWeight() {
        return weight;
    }



    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
