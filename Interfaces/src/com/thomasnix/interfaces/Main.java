package com.thomasnix.interfaces;

public class Main {
    public static void main(String args[]){
        Dog myDog = new Dog("Sassy");
        myDog.setWeight(25.0);
        myDog.setSound("Yap!");

        System.out.println("Information about " + myDog.getName() + "\n==========");
        System.out.println("\tName: " + myDog.getName() + "\n\tWeight: " + myDog.getWeight() + "\n\tNumber of Legs: " + myDog.getNumLegs() + "\n\tHas Teeth?: " + myDog.getHasTeeth() +
            "\n\tWeight: " + myDog.getWeight() + "\n\tSound: " + myDog.getSound());
        System.out.println(myDog.getName() + "'s Activities:");
        myDog.play();
        myDog.goForAWalk();
    }
}
