package com.techelevator;

//blueprint for all aliens
public class Alien {



    // define data members, or properties, instance variables, attributes
    // ALWAYS make them private!
    private String name;
    private int age = 0;
    private String color;
    private boolean hasBigHeadSize;
    private String speciesName;
    private Integer numberOfHeads;


    // final private attributes cannot be changed after being set
    private final String planetOfOrigin = "[Unknown planet of origin]";

    // declare or define the behaviors or methods -- getters and setters
    // public so we can call the methods!

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void setHasBigHeadSize(boolean hasBigHeadSize){
        this.hasBigHeadSize = hasBigHeadSize;
    }

    public boolean getHasBigHeadSize() {
        return this.hasBigHeadSize;
    }

    public String getPlanetOfOrigin(){
        return this.planetOfOrigin;
    }

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

    /*
     * CLASS VARIABLES
     *
     * static modifier,
     * may be public or private,
     * often final, but not required to be
     *
     */
    // constants
    public static final int ALIEN_ADULT_AGE = 15;

    // counter is shared by ALL Alien objects
    private static int alienCount = 0;

    // public getter for static property
    public static int getAlienCount() {
        return alienCount;
    }



    // equals and hashCode

    //toString
}
