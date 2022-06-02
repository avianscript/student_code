package com.techelevator.farm;

public class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "meow!");
    }

    @Override
    public void eat() {
        System.out.println("Eating Meow Mix...");
    }


//    @Override
//    public String getSound( ) {
//        return "meow!";
//    }
}
