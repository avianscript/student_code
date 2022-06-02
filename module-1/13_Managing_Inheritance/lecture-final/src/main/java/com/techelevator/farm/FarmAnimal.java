package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean sleeping = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if (sleeping) {
			return "Zzzzzz.....";
		} else {
			return sound;
		}
	}

	public void setSleeping(boolean sleeping) {
		setSleeping(sleeping, false);
	}


	public void setSleeping(boolean sleeping, boolean isMorning) {
		this.sleeping = sleeping;
	}

	public abstract void eat();
}