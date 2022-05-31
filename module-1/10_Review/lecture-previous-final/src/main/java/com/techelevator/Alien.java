package com.techelevator;

//blueprint for all aliens
public class Alien {



    // define data members, or properties, instance variables, attributes
    // ALWAYS make them private!
    private String name;
    private int age;
    private String color;
    private boolean hasBigHeadSize;
    private String speciesName;
    private Integer numberOfHeads;


    // final private attributes cannot be changed after being set
    private final String planetOfOrigin;

    public Alien() {
        this("[Unknown name]", 0, "Blah", false, "Unknown planet of origin",
                "Unknown species", 0);
    }

//    public Alien(String alienName) {
//        name = alienName;
//        planetOfOrigin = "Unknown planet of origin";
//    }

    public Alien(String name, int age, String color, boolean hasBigHead,
                  String planetOfOrigin, String speciesName, Integer numberOfHeads) {
        this.name = name;
        this.age = age;
        this.color = color;
        hasBigHeadSize = hasBigHead;
        this.planetOfOrigin = planetOfOrigin;
        this.speciesName = speciesName;
        this.numberOfHeads = numberOfHeads;
        alienCount++;
    }


    // declare or define the behaviors or methods -- getters and setters
    // public so we can call the methods!

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

//    public void setAge(Integer newAge) {
//        age = newAge;
//    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void setHasBigHeadSize(boolean hasBigHeadSize){
        this.hasBigHeadSize = hasBigHeadSize;
    }

    public boolean isBigHeadSize() {
        return this.hasBigHeadSize;
    }

    public String getPlanetOfOrigin(){
        return this.planetOfOrigin;
    }

    // cannot set planetOfOrigin once set

//    public void setPlanetOfOrigin(String planetOfOrigin) {
//        this.planetOfOrigin = planetOfOrigin;
//    }

    public void setSpeciesName(String speciesName){
        this.speciesName = speciesName;
    }

    public String getSpeciesName(){
        return this.speciesName;
    }

    public void setNumberOfHeads(Integer numberOfHeads) {
        this.numberOfHeads = numberOfHeads;
    }

    public Integer getNumberOfHeads() {
        return numberOfHeads;
    }

    // derived property
    public boolean isAdultAlien() {
        return age >= ALIEN_ADULT_AGE;
    }

    // instance methods
    public void celebrateBirthday() {
        age++;
        System.out.println("Happy birthday " + name + "!");
    }

    public void sayMyName() {
        System.out.println("My name is " + name);
    }

    public boolean isMyName(String match) {
        if (match.equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }

    /*
     * CLASS VARIABLES
     *
     * static modifier,
     * may be public or private,
     * often final, but not required to be
     *
     */
    // constants
    public static final int ALIEN_ADULT_AGE = 21;

    // counter is shared by ALL Alien objects
    private static int alienCount = 0;

    // public getter for static property
    public static int getAlienCount() {
        return alienCount;
    }

    public static void printAlienCount() {
        System.out.println("Aliens: " + alienCount);
    }



    // equals and hashCode

    //toString
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAdultAlien=" + isAdultAlien() +
                ", color='" + color + '\'' +
                ", hasBigHeadSize=" + hasBigHeadSize +
                ", speciesName='" + speciesName + '\'' +
                ", numberOfHeads=" + numberOfHeads +
                ", planetOfOrigin='" + planetOfOrigin + '\'' +
                '}';
    }
}
