package com.techelevator;

public class AlienDemo {

    //need a main (now this class is called an app)
    public static void main(String[] args) {
        //create an object of the Alien class
        Alien mork = new Alien();

        mork.setName("Mork");
        mork.setColor("beige");
        mork.setHasBigHeadSize(true);
        mork.setSpeciesName("Orkan");
        mork.setNumberOfHeads(26);


        System.out.println("Alien: \n\tName: " + mork.getName());
        System.out.println("\tAge: " + mork.getAge());
        System.out.println("\tAdult: " + mork.isAdultAlien());
        System.out.println("\tPlanet of Origin: " + mork.getPlanetOfOrigin());
        System.out.println("\tSpecies name: " + mork.getSpeciesName());
        System.out.println("\tColor: " + mork.getColor());
        System.out.println("\tBig Head Size" +
                "? " + mork.getHasBigHeadSize());
        System.out.println("\tNumber of heads: " + mork.getNumberOfHeads());

//        System.out.println();
//        mork.sayMyName();

//        System.out.println();
//        mork.celebrateBirthday();
//        System.out.println("Age: " + mork.getAge());

//        System.out.println();
//        System.out.println(mork);

//        Alien spock = new Alien("Spock", 150,  "Gray", true,
//        "Vulcan", "Vulcan", 1);
//
//        System.out.println();
//        System.out.println(spock);

//        System.out.println();
//        System.out.println("Alien is adult at age " + Alien.ALIEN_ADULT_AGE);

//        System.out.println();
//        System.out.println("Number of aliens: " + Alien.getAlienCount());

//        Alien generic = new Alien();
//        System.out.println();
//        System.out.println(generic);

//        System.out.println();
//        System.out.println("Number of aliens: " + Alien.getAlienCount());










    }

}
