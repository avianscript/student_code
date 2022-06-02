package com.techelevator.farm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig() };

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}


		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		Singable [] singables = new Singable[] { new Cow(), new Chicken(), new Pig(), new Tractor()  };

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}


		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		for (FarmAnimal animal : farmAnimals) {
			System.out.println(animal.getName() + " $" + animal.getPrice());
		}

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		Sellable [] sellables = new Sellable[] { new Cow(), new Chicken(), new Pig(), new Egg() };
//		Sellable [] sellables = new Sellable[] {  new Pig(), new Egg() };
		for (Sellable sellable : sellables) {
			System.out.println(sellable.getName() + " $" + sellable.getPrice());
		}

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		/*
		Sellable [] sellables = new Sellable[] { new Cow(), new Chicken(), new Pig(), new Egg() };
//		Sellable [] sellables = new Sellable[] {  new Pig(), new Egg() };
		for (Sellable sellable : sellables) {
			System.out.println(sellable.getName() + " $" + sellable.getPrice());
		}
		*/

		List<Sellable> sellableThings = new ArrayList<>();

		List<FarmAnimal> animalThings = Arrays.asList(farmAnimals);

		sellableThings.addAll(animalThings);

		sellableThings.add( new Egg() );

		for ( Sellable sellable : sellableThings) {
			System.out.println(sellable.getName() + " $" + sellable.getPrice());
		}

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		for (FarmAnimal animal : farmAnimals) {
			System.out.println(animal.getName() + " $" + animal.getPrice());

			if (animal instanceof Chicken) {
				((Chicken) animal).layEgg();
			}
		}

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		for (Singable singable : singables) {
			System.out.println(singable.getName() + " " + singable.getSound());

			if (singable instanceof Chicken) {
				((Chicken) singable).layEgg();
			}
		}

	}
}