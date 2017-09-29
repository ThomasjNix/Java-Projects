package com.thomasnix.interfaces;

public class Canine extends Animal {

    private String sound = "Bark!";
    private boolean hasTeeth = true;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean getHasTeeth() {
        return hasTeeth;
    }

    public void setHasTeeth(boolean hasTeeth) {
        this.hasTeeth = hasTeeth;
    }


}
