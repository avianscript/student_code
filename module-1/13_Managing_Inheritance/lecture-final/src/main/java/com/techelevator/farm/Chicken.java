package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public void eat() {
		System.out.println("Eating feed...");

		// only valid if sleeping is protected rather than private
//		sleeping = false;
	}

}