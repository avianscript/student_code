package com.techelevator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExamples {

    /*
        Maps generally do not have a guaranteed order but the TreeMap class maintains order.

        TreeMap works like the other Maps but it uses the equals and hash methods (which must be defined for
        the class being stored) to order entry keys by natural order
     */

    public static void main(String[] args) {

        LocalDate birthdate1 = LocalDate.parse("1970-03-15");
        Person person1 = new Person("Yoav", "Morahg", birthdate1, "123456789");

        LocalDate birthdate2 = LocalDate.parse("1940-10-11");
        Person person2 = new Person("Linda", "C", birthdate2, "123456789");

        LocalDate birthdate3 = LocalDate.parse("1939-03-21");
        Person person3 = new Person("John", "C", birthdate3, "123456789");

        System.out.println("******************************************************************************************************");
        System.out.println("                                          HashMap                                                    *");
        System.out.println("******************************************************************************************************");
        System.out.println("");


        Map<String, Person> unorderedPeople = new HashMap<>();
        unorderedPeople.put("YoavM", person1);
        unorderedPeople.put("LindaC", person2);
        unorderedPeople.put("JohnC", person3);

        // This order is NOT guaranteed to always be the same
        for (Map.Entry<String, Person> entry : unorderedPeople.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }


        System.out.println("");
        System.out.println("******************************************************************************************************");
        System.out.println("                                          TreeMap                                                    *");
        System.out.println("******************************************************************************************************");
        System.out.println("");


        Map<String, Person> orderedPeople = new TreeMap<>();
        orderedPeople.put("YoavM", person1);
        orderedPeople.put("LindaC", person2);
        orderedPeople.put("JohnC", person3);

        // This items will always be in natural sort order
        for (Map.Entry<String, Person> entry : orderedPeople.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }



    }
}
