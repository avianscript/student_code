package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {

    @Test
    public void givenAnimalName_shouldReturnGroupName () {
        //Arrange
        String expectedAnimal = "lion";
        String expectedHerd = "Pride" ;
        //Act
        AnimalGroupName animal = new AnimalGroupName();
        //Assert
       Assert.assertEquals(expectedHerd, animal.getHerd ("lion"));
    }
    @Test
     public void givenNull_shouldReturnUnknown () {
        String expectedHerd = "unknown";
        AnimalGroupName animal = new AnimalGroupName();
        Assert.assertEquals(expectedHerd, animal.getHerd ("null"));
     }
    @Test
    public void givenPenguin_shouldReturnUnknown () {
        String expectedHerd = "unknown";
        AnimalGroupName animal = new AnimalGroupName();
        Assert.assertEquals(expectedHerd, animal.getHerd("penguin"));
    }
    }
