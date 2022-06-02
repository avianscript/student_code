package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow theCow = new Cow();

		Chicken theChicken = new Chicken();
//		theChicken.setSleeping(true);

		// when sleeping is protected in FarmAnimal, it is accessible to Chicken because
		// it extends FarmAnimal but ALSO this class because it is in the same package
//		theChicken.sleeping = true;

		Pig thePig = new Pig();

		Cat theCat = new Cat();
		theCat.setSleeping(true);

		Tractor theTractor = new Tractor();

		// Cannot do this because FarmAnimal is abstract and cannot be instantiated
//		FarmAnimal theAnimal = new FarmAnimal("Generic animal", "some kind of sound!");

		Singable[] singables =
				new Singable[] { theCow, theChicken, thePig, theTractor, theCat };

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		FarmAnimal [] farmAnimals = new FarmAnimal[] { theCow, theChicken, thePig, theCat };

		System.out.println();
		
		for(FarmAnimal animal : farmAnimals) {
			System.out.print(animal.getName() + " ");
			animal.eat();
		}
	}
}